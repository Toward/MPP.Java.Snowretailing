package shlackAndCo.snowretailing.dal.enums;

public enum EquipmentTypes {
    board("сноуборд"),
    ski("горные лыжи"),
    mask("маска"),
    poles("лыжные палки"),
    helmet("шлем"),
    shoes("ботинки");

    private String value;

    EquipmentTypes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
