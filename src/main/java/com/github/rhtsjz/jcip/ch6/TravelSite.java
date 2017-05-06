package com.github.rhtsjz.jcip.ch6;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by smile on 2017/3/12.
 */
public class TravelSite {
    public static final int nthreads = 100;
    public static final ExecutorService exec
            = Executors.newFixedThreadPool(nthreads);

    private class QuoteTask implements Callable<TravelQuote> {
        private final TravelCompany company;
        private final TravelInfo travelInfo;

        public QuoteTask(TravelCompany company, TravelInfo travelInfo) {
            this.company = company;
            this.travelInfo = travelInfo;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public TravelQuote call() throws Exception {
            return company.solicitQuote(travelInfo);
        }

        public TravelQuote getFailureQuote(Throwable cause) {
            return null;
        }

        public TravelQuote getTimeoutQuote(CancellationException e) {
            return null;
        }
    }

    public List<TravelQuote> getRankedTravelQuotes(
            TravelInfo travelInfo,
            Set<TravelCompany> companySet,
            Comparator<TravelQuote> ranking, long time, TimeUnit unit)
            throws InterruptedException {

        List<QuoteTask> tasks = new ArrayList<>();
        for (TravelCompany company : companySet) {
            tasks.add(new QuoteTask(company, travelInfo));
        }

        List<Future<TravelQuote>> futureList = exec.invokeAll(tasks, time, unit);

        List<TravelQuote> quoteList = new ArrayList<>(tasks.size());
        Iterator<QuoteTask> taskIterator = tasks.iterator();
        for (Future<TravelQuote> future : futureList) {
            QuoteTask task = taskIterator.next();
            try {
                quoteList.add(future.get());
            } catch (ExecutionException e) {
                quoteList.add(task.getFailureQuote(e.getCause()));
                e.printStackTrace();
            } catch (CancellationException e) {
                quoteList.add(task.getTimeoutQuote(e));
            }
        }

        Collections.sort(quoteList, ranking);
        return quoteList;
    }
}
