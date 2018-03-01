
`JSONObject`
成员变量 
private final Map<String, Object> map;
public static final Object NULL = new Null();

流程：

1. 调用以字符串为参数的构造器
2. 构造器中调用以 `org.json.JSONTokener` 为参数的构造器
3. 调用无参数构造器初始化map域

