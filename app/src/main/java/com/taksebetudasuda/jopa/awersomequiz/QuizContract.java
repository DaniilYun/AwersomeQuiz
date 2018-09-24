package com.taksebetudasuda.jopa.awersomequiz;

/**
 * Created by Daniil on 06.08.2018.
 */
public final class QuizContract {

    private QuizContract() {
    }

    public static class QuestionTable {
        public static final String TABLE_NAME = "quiz_questions";
        public static final String TABLE_NAME2 = "quiz_categoties";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_ANSWER_NR_2 = "answer_nr2";
        public static final String COLUMN_CATEROGY = "category";
        public static final String COLUMN_SOLUTION1 = "solution1";
        public static final String COLUMN_SOLUTION1A = "solution1a";
        public static final String COLUMN_SOLUTION1B = "solution1b";
        public static final String COLUMN_SOLUTION2 = "solution2";
        public static final String COLUMN_SOLUTION2A = "solution2a";
        public static final String COLUMN_SOLUTION2B = "solution2b";
        public static final String COLUMN_SOLUTION3 = "solution3";
        public static final String COLUMN_SOLUTION3A = "solution3a";
        public static final String COLUMN_SOLUTION3B = "solution3b";
        public static final String COLUMN_CATEGORY_RECOMENDET1 = "recomend1";
        public static final String COLUMN_CATEGORY_RECOMENDET2 = "recomend2";
        public static final String COLUMN_CATEGORY_RECOMENDET3 = "recomend3";
        public static final String COLUMN_SOLUTION_FOR_VIEW = "solution_for_view";
        public static final String COLUMN_IMAGE_NAME = "imag";

    }

}
