package java8.lambdaExpr;

interface Trial {
    void trySum(int a,int b);
}

interface TrialReturnValInterface {
    int trySum(int a,int b);
}

public class LambdaExpression {
    public static void main(String[] args) {
        Trial trial = (a,b) -> System.out.println("Here is sum : "+ (a+b));
        trial.trySum(4,5);

        TrialReturnValInterface trialReturnValInterface = (a,b) -> a+b;


        System.out.println(trialReturnValInterface.trySum(4,8));
    }
}
