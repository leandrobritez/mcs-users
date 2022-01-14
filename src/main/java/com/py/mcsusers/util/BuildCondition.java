package com.py.mcsusers.util;

import java.sql.Statement;
import java.util.*;

public class BuildCondition {
    public static final String WHERE = "WHERE";
    public static final String SQL_OR = "OR";
    public static final String LEFT_BRACKEET = "";
    public static final String RIGHT_BRACKEET = "";
    public static final String SPACE = " ";
    public static final String LINE_JUMP = "\n";

    public static StringBuilder buildConditionWhere(Map<String,Object> param, List<Object> filterBuild, StringBuilder statement){
        statement.append(BuildCondition.WHERE);
        List<String> index = new LinkedList(param.keySet());
        int sizeList = index.size();
        param.entrySet().forEach(e -> {
            if(e.getValue() instanceof List){
                List<Object> paramBetween = (List<Object>) e.getValue();
                statement.append(BuildCondition.LEFT_BRACKEET.concat(
                        String.join(BuildCondition.SPACE.concat(BuildCondition.SQL_OR).concat(BuildCondition.SPACE),
                                Collections.nCopies(paramBetween.size(), e.getKey()))).concat(BuildCondition.RIGHT_BRACKEET));
                paramBetween.forEach(p-> filterBuild.add(p));

            }
        });
        return statement;
    }
}
//
//                statement.append(BuildCondition.LEFT_BRACKEET.concat(
//                        String.join(BuildCondition.SPACE.concat(BuildCondition.SQL_OR).concat(BuildCondition.SPACE),
//                        Collections.nCopies(paramBetween.size(), e.getKey()))).concat(BuildCondition.RIGHT_BRACKEET));
//                        paramBetween.forEach(p-> filterBuild.add(p));
