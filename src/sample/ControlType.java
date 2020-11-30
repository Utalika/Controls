package sample;

public enum ControlType {
    BUTTON("Button", "you can click it"),
    TEXT_FIELD("Text field", "you can write some text into it"),
    TEXT("Text", "plain text is displayed in it");


    String name;
    String description;

    private ControlType(String name, String description) {
        this.description = description;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
