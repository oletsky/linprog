package mathcomp.oletsky.linprog;

import scpsolver.constraints.LinearBiggerThanEqualsConstraint;
import scpsolver.lpsolver.LinearProgramSolver;
import scpsolver.lpsolver.SolverFactory;
import scpsolver.problems.LinearProgram;

public class LinProgSolver {
    public static double[] solveLinearProgTask(double[] objFun,
                                               double[][] constraintsMatrix,
                                               double[] constraintsVector) {

        //Maximization, all inequalities are >=
        if (constraintsMatrix.length!=constraintsVector.length) throw
                new RuntimeException("Constraint matrix doesn't correspond to vector");
        if (constraintsMatrix[0].length!=objFun.length) throw
                new RuntimeException("Function doesn't correspond to constraints");
        LinearProgram lp = new LinearProgram(objFun);
        for (int i=0; i<constraintsMatrix.length; i++) {
            lp.addConstraint(new LinearBiggerThanEqualsConstraint(constraintsMatrix[i],
                    constraintsVector[i], "c"+i));
        }

        lp.setMinProblem(false);
        LinearProgramSolver solver  = SolverFactory.newDefault();
        return solver.solve(lp);
    }
}

