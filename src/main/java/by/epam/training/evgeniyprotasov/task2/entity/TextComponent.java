package by.epam.training.evgeniyprotasov.task2.entity;

import java.io.File;
import java.util.List;

public interface TextComponent {
    boolean add(TextComponent textComponent);
    List<TextComponent> getComponents();
    ComponentType getComponentType();
    boolean remove(TextComponent textComponent);
    String getString();
}
