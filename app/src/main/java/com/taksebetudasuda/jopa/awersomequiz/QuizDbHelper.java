package com.taksebetudasuda.jopa.awersomequiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taksebetudasuda.jopa.awersomequiz.QuizContract.QuestionTable;

/**
 * Created by Daniil on 06.08.2018.
 */
public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyAwesomeQuiz.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable.COLUMN_ANSWER_NR_2 + " INTEGER, " +
                QuestionTable.COLUMN_CATEROGY + " TEXT" +
                ")";
        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME2 + " ( " +
                QuestionTable.COLUMN_CATEROGY + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION1 + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION1A + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION1B + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION2 + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION2A + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION2B + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION3 + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION3A + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION3B + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY_RECOMENDET1 + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY_RECOMENDET2 + " TEXT, " +
                QuestionTable.COLUMN_CATEGORY_RECOMENDET3 + " TEXT, " +
                QuestionTable.COLUMN_SOLUTION_FOR_VIEW + " TEXT, " +
                QuestionTable.COLUMN_IMAGE_NAME + " TEXT" +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        fillQuestionsTable();
        fillCategoriesTable();
    }

    private void fillCategoriesTable() {
        Category c1 = new Category(Question.CATEGORY_LIAR,
                "Вот жеж тыж фантазер", "Мифоман уровень депутат", "Мюнгхаузен, ты ли это?",
                "Надеюсь вы в изоляторе..","все в порядке?","ты победил/ла/ло",
                "ути пути батушный какой", "ложь - лишь недостаточность истины!", "многим правда и не нужна",
                Question.CATEGORY_VOZRAST, Question.CATEGORY_DEBILIZM, Question.CATEGORY_TERPIMOST, "Вы еще не проходили этот тест", QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c1);
        Category c2 = new Category(Question.CATEGORY_ALFA, "ебать ты пиздаболище", "фу какой", "ты случаем не синоптик?",
                "не может быть такого","ты праведник какой-то","молодесс так держать",
                "ты вполне нормальный", "соврать во благо - дело хорошее", "хорошо что ты честен и с собой",
                Question.CATEGORY_VOZRAST, Question.CATEGORY_DEBILIZM, Question.CATEGORY_TERPIMOST, "Вы еще не проходили этот тест",QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c2);
        Category c3 = new Category(Question.CATEGORY_BEREMENNOST,
                "Купите, пожалуй, нормальный тест", "Есть в вас что-то", "Муж уже знает?",
                "Вы вынашиваете сатану","скорее это пивное пузо","обратитесь к наркологу!",
                "Возможно вы беременны, но совсем немного", "Извините.. вы бесплодны", "Нужно больше секса",
                Question.CATEGORY_RAZVRATNOST, Question.CATEGORY_ALCOHOL, Question.CATEGORY_PRIVLEKATELNOST, "Вы еще не проходили этот тест",QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c3);
        Category c4 = new Category(Question.CATEGORY_HZ, "ебать ты пиздаболище", "фу какой", "ты случаем не синоптик?",
                "не может быть такого","ты праведник какой-то","молодесс так держать",
                "ты вполне нормальный", "соврать во благо - дело хорошее", "хорошо что ты честен и с собой",
                Question.CATEGORY_VOZRAST, Question.CATEGORY_DEBILIZM, Question.CATEGORY_TERPIMOST, "Вы еще не проходили этот тест",QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c4);
        Category c5 = new Category(Question.CATEGORY_VOZRAST, "ебать ты пиздаболище", "фу какой", "ты случаем не синоптик?",
                "не может быть такого","ты праведник какой-то","молодесс так держать",
                "ты вполне нормальный", "соврать во благо - дело хорошее", "хорошо что ты честен и с собой",
                Question.CATEGORY_VOZRAST, Question.CATEGORY_DEBILIZM, Question.CATEGORY_TERPIMOST, "Вы еще не проходили этот тест",QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c5);
        Category c6 = new Category(Question.CATEGORY_DOVERCHIVOST,
                "ебать ты пиздаболище", "фу какой", "ты случаем не синоптик?",
                "не может быть такого","ты праведник какой-то","молодесс так держать",
                "ты вполне нормальный", "соврать во благо - дело хорошее", "хорошо что ты честен и с собой",
                Question.CATEGORY_VOZRAST, Question.CATEGORY_ALFA, Question.CATEGORY_TERPIMOST, "Вы еще не проходили этот тест",QuestionTable.COLUMN_IMAGE_NAME);
        addCategories(c6);
    }


    private void fillQuestionsTable() {
        Question q1 = new Question("Часто ли вас тошнит?", "боуэээ-э-ээ... эээоугхкх.. уэиксуайзед",
                "после седьмой бутылки винтажного Моэт и Шандон", "Иногда приходится",
                1, 2, Question.CATEGORY_BEREMENNOST);
        addQuestion(q1);
        Question q2 = new Question("Что бы вы хотели съесть?", "жирафье мясо фаршированное ананасами",
                "что-то там с повидлом", "Кило водяры вкатило бы",
                1, 3, Question.CATEGORY_BEREMENNOST);
        addQuestion(q2);
        Question q3 = new Question("Был ли у вас в течении года секс?", "Только в мозг",
                "Только ленивый со мной не переспал еще", "С будуна всего и не упомнишь",
                2, 3, Question.CATEGORY_BEREMENNOST);
        addQuestion(q3);
        Question q4 = new Question("Видите ли вы свой пах?", "только в зеркале",
                "Зачем такой выопрос слепой женщине?", "раз в месяц вижу... и алименты ска не платит!",
                3, 2, Question.CATEGORY_BEREMENNOST);
        addQuestion(q4);
        Question q5 = new Question("Есть ли у вас задержка?", "задержка зарплаты",
                "задержка минструации", "задержка умтсвенного развития",
                2, 3, Question.CATEGORY_BEREMENNOST);
        addQuestion(q5);


        Question q6 = new Question("Бомж просит у вас косарь. Говорит, что деньги пустит в оборот и в конце квартала отдаст вам косарь +16рублей. Ваши действия:",
                "Пойду на контакт (пройду в ноги, выйду на суфлекс и воткну его(потом возможно отгрызу ему бок))",
                "Убегу в панике, издавая странные звуки типа: \"Хосподи Исуси Алохалалала\"",
                "Дам ему 2тыщи 137рублей и через квартал буду ждать 2тыщи 171рубль 19копеек",
                3, 1, Question.CATEGORY_DOVERCHIVOST);
        addQuestion(q6);
        Question q7 = new Question("Уступая место в общественном транспорте одноногому человеку вы:",
                "Спрашиваю документ, подтверждающий его одноногость",
                "резко помогаю ему присесть, потом мы весело провоидм время",
                "внимательно расматриваю его культю и места, куда бы он мог ее заныкать",
                2, 1, Question.CATEGORY_DOVERCHIVOST);
        addQuestion(q7);
        Question q8 = new Question("Приходишь значит домой, а там супруг/супруга изменяет:",
                "Да быть такого не может! Он/она не такой/такая!!!",
                "Вспоминаю что сегодня 1е апреля, восхищаюсь его/ее чувством юмора",
                "Фоткаю, удостоверяюсь, что это действительно супруг/супруга, удостовверяюсь в факте измены, расстраиваюсь",
                1, 3, Question.CATEGORY_DOVERCHIVOST);
        addQuestion(q8);


        Question q9 = new Question("Завидуете ли вы мажорам?", "Нет! к этим везучим ублюдкам никаких чувств не испытываю",
                "Да,ведь я всего добился сам... хоть я и бомж... и тем не менее", "Нет. Ведь им приходится тратить так много денег",
                1, 2, Question.CATEGORY_LIAR);
        addQuestion(q9);
        Question q10 = new Question("Ковыряетесь ли вы в носу?", "Вчера последний палец сломал. теперь не могу((",
                "Нет, ведь у меня есть для этого служанка", "Да, но все нарытые улики я уничтожаю! (вы поняли о чем я)",
                2, 3, Question.CATEGORY_LIAR);
        addQuestion(q10);
        Question q11 = new Question("Крали ли вы что нибудь?", "Вы ничего не докажете!",
                "Однажды я украл листовку у промоутера", "Откуда вы думаете у меня деньги на служанку?",
                1, 2, Question.CATEGORY_LIAR);
        addQuestion(q11);
        Question q12 = new Question("Вы синоптик?", "По данным гисметеоцентра... нет!",
                "Вчера вот меня изнасиловали... значит ли это что теперь я синоптик?", "Сам такой!",
                1, 2, Question.CATEGORY_LIAR);
        addQuestion(q12);
        Question q13 = new Question("Склонны ли в к измене?", "Жена, это ты?",
                "Муж, это ты?", "Некому мне изменять(плачь в захлеб)... И не с кем(достал нож и застрелился!)",
                1, 3, Question.CATEGORY_LIAR);
        addQuestion(q13);
    }

    private void addQuestion(Question question) {
        ContentValues cv = QuestionLab.getContentValuesForQuestion(question);
        db.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    private void addCategories(Category category) {
        ContentValues cv = QuestionLab.getContentValuesForCategotyes(category);
        db.insert(QuestionTable.TABLE_NAME2, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME2);
        onCreate(db);
    }


}
