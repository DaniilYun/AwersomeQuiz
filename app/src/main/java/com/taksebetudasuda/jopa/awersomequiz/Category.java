package com.taksebetudasuda.jopa.awersomequiz;

/**
 * Created by Daniil on 09.08.2018.
 */
public class Category {

    private String categoty;
    private String result1a;
    private String result1b;
    private String result1c;
    private String result2a;
    private String result2b;
    private String result2c;
    private String result3a;
    private String result3b;
    private String result3c;
    private String recomend1;
    private String recomend2;
    private String recomend3;
    private String resultForView;
    private String imageName;

    public Category() {
    }

    public Category(String categoty, String result1a, String result1b, String result1c, String result2a, String result2b,
                    String result2c, String result3a, String result3b, String result3c,
                    String recomend1, String recomend2, String recomend3, String resultForView, String imageName) {
        this.categoty = categoty;
        this.result1a = result1a;
        this.result1b = result1b;
        this.result1c = result1c;
        this.result2a = result2a;
        this.result2b = result2b;
        this.result2c = result2c;
        this.result3a = result3a;
        this.result3b = result3b;
        this.result3c = result3c;
        this.recomend1 = recomend1;
        this.recomend2 = recomend2;
        this.recomend3 = recomend3;
        this.resultForView = resultForView;
        this.imageName = imageName;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public String getResult1a() {
        return result1a;
    }

    public void setResult1a(String result1a) {
        this.result1a = result1a;
    }

    public String getResult1b() {
        return result1b;
    }

    public void setResult1b(String result1b) {
        this.result1b = result1b;
    }

    public String getResult1c() {
        return result1c;
    }

    public void setResult1c(String result1c) {
        this.result1c = result1c;
    }

    public String getResult2a() {
        return result2a;
    }

    public void setResult2a(String result2a) {
        this.result2a = result2a;
    }

    public String getResult2b() {
        return result2b;
    }

    public void setResult2b(String result2b) {
        this.result2b = result2b;
    }

    public String getResult2c() {
        return result2c;
    }

    public void setResult2c(String result2c) {
        this.result2c = result2c;
    }

    public String getResult3a() {
        return result3a;
    }

    public void setResult3a(String result3a) {
        this.result3a = result3a;
    }

    public String getResult3b() {
        return result3b;
    }

    public void setResult3b(String result3b) {
        this.result3b = result3b;
    }

    public String getResult3c() {
        return result3c;
    }

    public void setResult3c(String result3c) {
        this.result3c = result3c;
    }

    public String getRecomend1() {
        return recomend1;
    }

    public void setRecomend1(String recomend1) {
        this.recomend1 = recomend1;
    }

    public String getRecomend2() {
        return recomend2;
    }

    public void setRecomend2(String recomend2) {
        this.recomend2 = recomend2;
    }

    public String getRecomend3() {
        return recomend3;
    }

    public void setRecomend3(String recomend3) {
        this.recomend3 = recomend3;
    }

    public String getResultForView() {
        return resultForView;
    }

    public void setResultForView(String resultForView) {
        this.resultForView = resultForView;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String[] getAllRecomendation() {
        return new String[]{
                result1a,
                result1b,
                result1c,
                result2a,
                result2b,
                result2c,
                result3a,
                result3b,
                result3c,
                recomend1,
                recomend2,
                recomend3
        };
    }
}
