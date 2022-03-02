package com.example.sidebar.fragment;

public class faqclass {

    String question,ans;
    private boolean expand;

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public faqclass(String question, String ans) {
        this.question = question;
        this.ans = ans;
        this.expand = false;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    @Override
    public String toString() {
        return "faqclass{" +
                "question='" + question + '\'' +
                ", ans='" + ans + '\'' +
                '}';
    }
}
