module dev.reymark {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive core.fx;
    requires transitive core.db;
    requires java.base;
    requires core.util;
    requires javafx.base;
    requires atlantafx.base;

    opens dev.reymark to javafx.fxml;
    opens dev.reymark.app to javafx.fxml;

    exports dev.reymark;
    exports dev.reymark.app;
}
