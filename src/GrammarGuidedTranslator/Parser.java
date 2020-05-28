package GrammarGuidedTranslator;

import java.io.*;

/**
 *一个将中缀表达式翻译为后缀表达式的Java程序
 */
public class Parser {
    static int lookhead;

    public Parser() throws IOException {
        lookhead = System.in.read();
    }

    void expr() throws IOException {
        term();
        while(true) {
            if( lookhead == '+'){
                match('+'); term(); System.out.write('+');
            }
            else if (lookhead == '-') {
                match('-'); term(); System.out.write('-');
            }
            else return;
        }
    }

    void term() throws IOException {
        if (Character.isDigit((char)lookhead)) {
            System.out.write((char)lookhead);match(lookhead);
        }
        else throw new Error("syntax error");
    }

    void match(int t) throws IOException {
        if (lookhead == t) lookhead = System.in.read();
        else throw new Error("syntax error");
    }
}
