// import java.util.HashMap;
// import java.util.Map;

// public class solutionJianZhiOffer20 {

//     public boolean isNumber(String s) {
//         Map<State, Map<CharType, State>> stateTransitionTable =
//                 new HashMap<State, Map<CharType, State>>();

//         // 初始状态
//         Map<CharType, State> initialMap = new HashMap<>() {
//             /**
//             *
//             */
//             private static final long serialVersionUID = 1L;

//             {
//                 put(CharType.CHAR_SPACE, State.S_INITIAL);
//                 put(CharType.CHAR_NUMBER, State.S_INTEGER);
//                 put(CharType.CHAR_POINT, State.S_POINT_WITHOUT_INT);
//                 put(CharType.CHAR_SIGN, State.S_INT_SIGN);
//             }
//         };
//         stateTransitionTable.put(State.S_INITIAL, initialMap);

//         // 初始符号状态
//         Map<CharType, State> intSignMap = new HashMap<CharType, State>() {
//             /**
//             *
//             */
//             private static final long serialVersionUID = 1L;

//             {
//                 put(CharType.CHAR_NUMBER, State.S_INTEGER);
//                 put(CharType.CHAR_POINT, State.S_POINT_WITHOUT_INT);
//             }
//         };
//         stateTransitionTable.put(State.S_INT_SIGN, intSignMap);

//         // 数值状态
//         Map<CharType, State> integerMap = new HashMap<CharType, State>() {

//             /**
//             *
//             */
//             private static final long serialVersionUID = 1L;

//             {
//                 put(CharType.CHAR_NUMBER, State.S_INTEGER);
//                 put(CharType.CHAR_EXP, State.S_EXP);
//                 put(CharType.CHAR_POINT, State.S_POINT);
//                 put(CharType.CHAR_SPACE, State.S_END);
//             }
//         };
//         stateTransitionTable.put(State.S_INTEGER, integerMap);

//         // 小数点状态
//         Map<CharType, State> pointMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_FRACTION);
//                 put(CharType.CHAR_EXP, State.S_EXP);
//                 put(CharType.CHAR_SPACE, State.S_END);
//             }
//         };
//         stateTransitionTable.put(State.S_POINT, pointMap);

//         // 无整数小数点状态
//         Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_FRACTION);
//             }
//         };
//         stateTransitionTable.put(State.S_POINT_WITHOUT_INT, pointWithoutIntMap);

//         // 小数状态
//         Map<CharType, State> fractionMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_FRACTION);
//                 put(CharType.CHAR_EXP, State.S_EXP);
//                 put(CharType.CHAR_SPACE, State.S_END);
//             }
//         };
//         stateTransitionTable.put(State.S_FRACTION, fractionMap);

//         // 符号e状态
//         Map<CharType, State> expMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_EXP_NUMBER);
//                 put(CharType.CHAR_SIGN, State.S_EXP_SIGN);
//             }
//         };
//         stateTransitionTable.put(State.S_EXP, expMap);

//         // 符号e后的正负号
//         Map<CharType, State> expSignMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_EXP_NUMBER);
//             }
//         };
//         stateTransitionTable.put(State.S_EXP_SIGN, expSignMap);

//         // 符号e后的正负号后的整数
//         Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_NUMBER, State.S_EXP_NUMBER);
//                 put(CharType.CHAR_SPACE, State.S_END);
//             }
//         };
//         stateTransitionTable.put(State.S_EXP_NUMBER, expNumberMap);

//         // 结束状态
//         Map<CharType, State> endMap = new HashMap<CharType, State>() {
//             {
//                 put(CharType.CHAR_SPACE, State.S_END);
//             }
//         };
//         stateTransitionTable.put(State.S_END, endMap);



//         State state = State.S_INITIAL;
//         char[] sc = s.toCharArray();
//         int length = sc.length;
//         CharType type;
//         for (int i = 0; i < length; i++) {
//             type = toCharType(s.charAt(i));
//             if (!stateTransitionTable.get(state).containsKey(type)) {
//                 return false;
//             } else {
//                 state = stateTransitionTable.get(state).get(type);
//             }
//         }
//         return state == State.S_INTEGER || state == State.S_POINT || state == State.S_FRACTION
//                 || state == State.S_EXP_NUMBER || state == State.S_END;
//     }

//     public CharType toCharType(char ch) {
//         if (ch >= '0' && ch <= '9') {
//             return CharType.CHAR_NUMBER;
//         } else if (ch == 'e' || ch == 'E') {
//             return CharType.CHAR_EXP;
//         } else if (ch == '.') {
//             return CharType.CHAR_POINT;
//         } else if (ch == '+' || ch == '-') {
//             return CharType.CHAR_SIGN;
//         } else if (ch == ' ') {
//             return CharType.CHAR_SPACE;
//         } else {
//             return CharType.CHAR_ILLEGAL;
//         }
//     }

//     enum State {
//         S_INITIAL, S_INT_SIGN, S_INTEGER, S_POINT, S_POINT_WITHOUT_INT, S_FRACTION, S_EXP, S_EXP_SIGN, S_EXP_NUMBER, S_END
//     }

//     enum CharType {
//         CHAR_NUMBER, CHAR_EXP, CHAR_POINT, CHAR_SIGN, CHAR_SPACE, CHAR_ILLEGAL
//     }



//     public static void main(String[] args) {
//         System.out.print(new solutionJianZhiOffer20().isNumber(". 1"));
//     }



//     /***************************
//      * method in book cannot pass all test case
//      ***************************************/

//     // private char[] sc;
//     // private int index;

//     // public boolean isNumber(String s) {
//     // sc = s.trim().toCharArray();
//     // index = 0;
//     // if (s.length() < 1) {
//     // return false;
//     // }
//     // boolean numeric = scanInteger();

//     // // decimal point
//     // if (index < sc.length && sc[index] == '.') {
//     // index++;
//     // // return false if there are not numbers before or after the decimal point
//     // return numeric || scanUnsignedInteger();
//     // }

//     // if (index < sc.length && (sc[index] == 'e' || sc[index] == 'E')) {
//     // index++;
//     // // return true when there are number before and after the decimal point
//     // return numeric && scanInteger();
//     // }

//     // return numeric && (index == sc.length);
//     // }

//     // public boolean scanInteger() {
//     // if (index < sc.length && (sc[index] == '+' || sc[index] == '-')) {
//     // index++;
//     // }
//     // return scanUnsignedInteger();
//     // }

//     // public boolean scanUnsignedInteger() {
//     // int temp = index;
//     // while (index < sc.length && sc[index] >= '0' && sc[index] <= '9') {
//     // // skip number 0-9
//     // index++;
//     // }
//     // return index > temp;
//     // }
// }
