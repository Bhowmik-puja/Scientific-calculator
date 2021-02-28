package com.example.scientificcalculator;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView textView, textView2;
    String exp = "";
    Double result = 0.0;
    int openbrac = 0, closebrac = 0;
    int inv = 0,hyp = 0;
    Button sinbtn, cosbtn, tanbtn, sqr, root, log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view_input);
        textView2 = findViewById(R.id.text_view_output);
        sinbtn = findViewById(R.id.btn_sin);
        cosbtn = findViewById(R.id.btn_cos);
        tanbtn = findViewById(R.id.btn_tan);
        sqr = findViewById(R.id.btn_xsquare);
        log = findViewById(R.id.btn_log);
        root = findViewById(R.id.btn_root);
    }
    public void zeroBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "0");
        exp = exp+ "0";

    }

    public void dotBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + ".");
        exp = exp +".";
    }

    public void oneBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "1");
        exp = exp+ "1";

    }

    public void twoBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "2");
        exp = exp+ "2";

    }

    public void threBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "3");
        exp = exp + "3";

    }


    public void fourBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "4");
        exp = exp + "4";

    }

    public void fiveBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "5");
        exp = exp + "5";
    }

    public void sixBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "6");
        exp = exp + "6";

    }

    public void sevenBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "7");
        exp = exp + "7";


    }

    public void eightBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "8");
        exp = exp + "8";

    }

    public void nineBtn(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "9");
        exp = exp + "9";

    }

    public void clear(View view) {
        textView.setText("");
        textView2.setText("");
        exp = "";
        openbrac = 0;
        closebrac = 0;
    }

    public void backspace(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if (s.length() > 1) {
            if(s.substring((s.length()-1)).equals("("))
            {
                openbrac--;
            }
            else if(s.substring((s.length()-1)).equals(")"))
            {
                closebrac--;
            }
            s = s.substring(0, s.length() - 1);
            exp = exp.substring(0, exp.length() - 1);
            textView.setText(s);
            String lastValue = exp.substring(exp.length()-1);
            if(lastValue.equals("+")|| lastValue.equals("-") || lastValue.equals("*") || lastValue.equals("/") || openbrac!=closebrac){
                textView2.setText("Syntax ERROR");
            }
            else
            {
                ExtendedDoubleEvaluator expression = new ExtendedDoubleEvaluator();
                try {
                    result = expression.evaluate(exp);
                    textView2.setText("" + result);
                } catch (ArithmeticException e) {
                    textView2.setText("MATH ERROR");
                }
                catch (Exception e)
                {
                    textView2.setText("Error");
                }
            }

        }
        else {
            textView.setText("");
            textView2.setText("");
            exp = "";
        }
    }

    public void Plus(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "+");
        exp = exp + "+";

    }

    public void minus(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "-");
        exp = exp + "-";
    }

    public void multiply(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "x");
        exp = exp + "*";
    }

    public void division(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "÷");
        exp = exp + "/";
    }

    public void equal(View view) {

        String lastValue = exp.substring(exp.length()-1);
        if(lastValue.equals("+")|| lastValue.equals("-") || lastValue.equals("*") || lastValue.equals("/") || openbrac != closebrac){
            textView2.setText("Syntax ERROR");
        }
        else
        {
            ExtendedDoubleEvaluator expression = new ExtendedDoubleEvaluator();
            try {
                result = expression.evaluate(exp);
                textView2.setText("" + result);
            } catch (ArithmeticException e) {
                textView2.setText("MATH ERROR");
            }
            catch (Exception e)
            {
                textView2.setText("Error");
            }
        }


    }

    public void openbrac(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "(");
        exp = exp + "(";
        openbrac++;
    }

    public void closebrac(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + ")");
        exp = exp + ")";
        closebrac++;
    }

    public void pi(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "π");
        exp = exp + "pi";
//
//        if(exp.length()==0)
//        {
//            exp = exp + "pi";
//        }
//        else if(exp.substring(exp.length()-1).equals("0")|| exp.substring(exp.length()-1).equals("1") ||exp.substring(exp.length()-1).equals("2") ||exp.substring(exp.length()-1).equals("3") ||exp.substring(exp.length()-1).equals("4")|| exp.substring(exp.length()-1).equals("5") ||exp.substring(exp.length()-1).equals("6")||exp.substring(exp.length()-1).equals("7")||exp.substring(exp.length()-1).equals("8")||exp.substring(exp.length()-1).equals("8")){
//            exp = exp + "*" + "pi";
//        }
    }

    public void log(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "log(");
        openbrac++;
        exp = exp + "log(";
    }

    public void ln(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s + "ln(");
        openbrac++;
        exp = exp + "ln(";
    }

    public void sin(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if(inv == 1)
        {
            textView.setText(s + "asin(");
            openbrac++;
            exp = exp + "asin(";
        }
        else if(hyp == 1)
        {
            textView.setText(s+"sinh(");
            openbrac++;
            exp = exp + "sinh(";
        }
        else
        {
            textView.setText(s + "sin(");
            openbrac++;
            exp = exp + "sin(";
        }

    }

    public void cos(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if(inv == 1)
        {
            textView.setText(s + "acos(");
            openbrac++;
            exp = exp + "acos(";
        }
        else if(hyp == 1)
        {
            textView.setText(s+"cosh(");
            openbrac++;
            exp = exp + "cosh(";
        }
        else
        {
            textView.setText(s + "cos(");
            openbrac++;
            exp = exp + "cos(";
        }
    }

    public void tan(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if(inv == 1)
        {
            textView.setText(s + "atan(");
            openbrac++;
            exp = exp + "atan(";
        }
        else if(hyp == 1)
        {
            textView.setText(s+"tanh(");
            openbrac++;
            exp = exp + "tanh(";
        }
        else
        {
            textView.setText(s + "tan(");
            openbrac++;
            exp = exp + "tan(";
        }
    }

    public void inverse(View view) {
        if(inv ==0){
            inv = 1;
            hyp = 0;
            sinbtn.setText(R.string.asin);
            cosbtn.setText(R.string.acos);
            tanbtn.setText(R.string.atan);
            root.setText(R.string.cuberoot);
        }
        else
        {
            inv= 0;
            sinbtn.setText("sin");
            cosbtn.setText("cos");
            tanbtn.setText("tan");
            root.setText("√");
        }

    }

    public void hyp(View view) {
        if(hyp ==0){
            hyp = 1;
            inv = 0;
            sinbtn.setText("sinh");
            cosbtn.setText("cosh");
            tanbtn.setText("tanh");
        }
        else
        {
            hyp = 0;
            sinbtn.setText("sin");
            cosbtn.setText("cos");
            tanbtn.setText("tan");
        }
    }

    public void xsquare(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if(s.length() == 0)
        {
            textView2.setText("Syntax Error");
        }
        else
        {
            textView.setText(s+ "^");
            exp = exp + "^";

        }
    }
    public void facto(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
            textView.setText(s+ "facto(");
            exp = exp +"facto(";
            openbrac++;

    }
//    static BigInteger factorial(int N)
//    {
//        // Initialize result
//        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE
//
//        // Multiply f with 2, 3, ...N
//        for (int i = 2; i <= N; i++)
//            f = f.multiply(BigInteger.valueOf(i));
//
//        return f;
//    }


    public void sqrt(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        if(inv == 1)
        {
            textView.setText(s+"cbrt(");
            exp = exp+"cbrt(";
            openbrac++;

        }
        else{
            textView.setText(s+"sqrt(");
            exp = exp+ "sqrt(";
            openbrac++;
        }


    }

    public void e(View view) {
        String s = textView.getText().toString();
        textView.setGravity(Gravity.TOP | Gravity.LEFT);
        textView.setText(s+"e");
        exp = exp +"e";

    }
}