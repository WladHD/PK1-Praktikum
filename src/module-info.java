module pk1 {
requires java.desktop;
requires javafx.controls;
requires javafx.graphics;
requires javafx.base;
opens de.wlad to javafx.controls, javafx.base, javafx.graphics;
opens de.wlad.stages to javafx.controls, javafx.base, javafx.graphics;
}
