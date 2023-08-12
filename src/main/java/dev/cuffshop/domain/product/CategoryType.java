package dev.cuffshop.domain.product;

public enum CategoryType {
    KOREANWESTERN("한식/양식"),
    CHINESEJAPAN("중식/일식"),
    SOUTHEASTASIAN("동남아"),
    SALAD("샐러드"),
    PREMIUM("프리미엄밀키트");

    private final String description;

    CategoryType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
