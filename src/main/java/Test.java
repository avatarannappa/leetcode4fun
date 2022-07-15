import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

class Test {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        String script = "result = param1 + 1;\n"
            + "if (ob == null) {\n"
            + "    rr = result;\n"
            + "} else {\n"
            + "    rr = ob.bar_style * 66 + result;\n"
            + "}";
        Map<String, Object> param = new HashMap<>();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        param.put("x", 1);
        param.put("list", list);

        Map<String, Integer> ob = new HashMap<>();
        ob.put("bar_style", 1);
        param.put("param1", 1);
        param.put("ob", null);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        Bindings bindings = engine.createBindings();
        bindings.putAll(param);
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(script);
        Object res = compiledScript.eval(bindings);
        System.out.println(res);
//        
    }
    
    void test1() throws Exception {
        String script = "def myFun(param1, ob) {\n"
            + "    result = param1 + 1\n"
            + "    def rr = -1\n"
            + "    if (ob == null) {\n"
            + "        rr = result\n"
            + "    } else {\n"
            + "        rr = ob.bar_style * 66 + result\n"
            + "    }\n"
            + "    return rr\n"
            + "}";
        Map<String, Object> param = new HashMap<>();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        param.put("x", 1);
        param.put("list", list);

        Map<String, Integer> ob = new HashMap<>();
        ob.put("bar_style", 1);
        param.put("param1", 1);
        param.put("ob", ob);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        Bindings bindings = engine.createBindings();
        bindings.putAll(param);
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(script);
        Object res = compiledScript.eval(bindings);
        Invocable in = (Invocable) compiledScript;

        Object r = ((Invocable) compiledScript).invokeFunction("myFun",1, null);
        System.out.println(r);
    }
    
    void test2() throws Exception {
        String script = "def myFun(param1, ob) {\n"
            + "    result = param1 + 1\n"
            + "    def rr = -1\n"
            + "    if (ob == null) {\n"
            + "        rr = result\n"
            + "    } else {\n"
            + "        rr = ob.bar_style * 66 + result\n"
            + "    }\n"
            + "    return rr\n"
            + "}";
        Map<String, Object> param = new HashMap<>();
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        param.put("x", 1);
        param.put("list", list);

        Map<String, Integer> ob = new HashMap<>();
        ob.put("bar_style", 1);
        param.put("param1", 1);
        param.put("ob", ob);
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
        Bindings bindings = engine.createBindings();
        bindings.putAll(param);
        Compilable compilable = (Compilable) engine;
        CompiledScript compiledScript = compilable.compile(script);
        Object res = compiledScript.eval(bindings);
        Invocable in = (Invocable) compiledScript;

        Object r = ((Invocable) compiledScript).invokeFunction("myFun",1, null);
        System.out.println(r);
//        for (int i = 0; i < 10; i++) {
//            new Runnable() {
//                @Override
//                public void run() {
//                    Compilable compilable = (Compilable) engine;
//                    CompiledScript compiledScript = null;
//                    try {
//                        compiledScript = compilable.compile(script);
//                        for (int j = 0; j < 10; j++) {
//                            Object res = compiledScript.eval(bindings);
//
//                            if (res instanceof Invocable) {
//                                Object r = ((Invocable) res).invokeFunction("add",1);
//                                System.out.println(r);;
//                            } else {
//                                System.out.println(res);
//                            }
//                            
//                        }
//                    } catch (ScriptException | NoSuchMethodException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }.run();
//        }
    }
        
}