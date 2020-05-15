package mathcomp.oletsky.linprog;

import mathcomp.oletsky.mathhelper.VectMatr;


public class LinProgTester {
    public static void main(String[] args) {
        double[] objFun={3.,4.};
        double[][] constraintsMatrix={
                {-1.,-2.} ,
                {3.,-1},
                {-1.,1.}
        };
        double[] constraintVector={-14.,0.,-2.};

        double[] sol = LinProgSolver.solveLinearProgTask(
                objFun,
                constraintsMatrix,
                constraintVector
        );
        System.out.println("************");
        System.out.println("Solution:");
        VectMatr.defaultOutputVector(sol);
    }
}
