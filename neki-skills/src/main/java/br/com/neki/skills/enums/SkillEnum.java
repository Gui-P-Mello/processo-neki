package br.com.neki.skills.enums;

public enum SkillEnum {
    JAVA("Java"),
    PYTHON("Python"),
    JAVASCRIPT("JavaScript"),
	INGLES("Inglês"),
	ESPANHOL("Espanhol");

    private final String nomeSkill;

    SkillEnum(String nomeSkill) {
        this.nomeSkill = nomeSkill;
    }

    public String getNomeSkill() {
        return nomeSkill;
    }
}