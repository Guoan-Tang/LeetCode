

import java.util.*;

public class solution5525 {
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");
        print(t.getInheritanceOrder());
        t.death("bob");
        print(t.getInheritanceOrder());
    }

    public static void print(List<String> input) {
        for (String s : input) {
            System.out.println(s);
        }
    }
}

class ThroneInheritance {
    String king;
    HashMap<String, List<String>> childrens;
    HashSet<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        childrens = new HashMap<>();
        childrens.put(kingName, new LinkedList<String>());
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        List<String> list = childrens.get(parentName);
        if (list == null) {
            list = new LinkedList<>();
            list.add(childName);
            childrens.put(parentName, list);
        } else {
            list.add(childName);
        }
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new LinkedList<String>();
        dfs(res, king);
        return res;
    }

    public void dfs(List<String> res, String name) {
        if (!dead.contains(name)) {
            res.add(name);
        }
        List<String> temp;
        if ((temp = childrens.get(name)) != null) {
            for (String s : temp) {
                dfs(res, s);
            }
        }
    }
}