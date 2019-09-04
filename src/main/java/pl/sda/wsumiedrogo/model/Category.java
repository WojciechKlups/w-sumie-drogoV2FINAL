package pl.sda.wsumiedrogo.model;

public enum Category {
    LAPTOPS("Laptops"),SMARTPHONES("Smartphones"),CAMERAS("Cameras"),ACCESSORIES("Accessories");

    private final String displayValue;

    Category(String displayValue){
        this.displayValue = displayValue;
    }

    public String getDisplayValue(){
        return displayValue;
    }

}
