package com.mashibing.springioc;

public class XMan extends Person {
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return super.toString() +  " XMan{" +
                "skill='" + skill + '\'' +
                '}';
    }
}
