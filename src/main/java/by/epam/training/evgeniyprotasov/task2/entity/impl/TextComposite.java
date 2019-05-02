package by.epam.training.evgeniyprotasov.task2.entity.impl;

import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static by.epam.training.evgeniyprotasov.task2.parser.MainParser.*;

public class TextComposite implements TextComponent,Cloneable{
    private ComponentType TYPE;
    private List<TextComponent> textComponents;

    public TextComposite(ComponentType type){
        this.TYPE = type;
        textComponents = new ArrayList<>();
    }


    public String getString() {
        StringBuilder strBuilder = new StringBuilder();

        for (TextComponent component : textComponents) {
            if (component.getComponentType()==ComponentType.PARAGRAPH)strBuilder.append("    ");
            strBuilder.append(component.getString());

            if (component.getComponentType() == ComponentType.UNIT) {
                strBuilder.append(" ");
                String symbol = strBuilder.substring(strBuilder.length() - 1, strBuilder.length());

                Pattern p = Pattern.compile(PUNCTUATION_REGEX);
                Matcher m = p.matcher(symbol);

                if (!m.matches()) {
                    Pattern.compile(SENTENCE_SPLIT_REGEX);
                    m = p.matcher(symbol);
                }

                if (!m.matches()) {
                    Pattern.compile(BRACKET_REGEX);
                    m = p.matcher(symbol);
                }

                if (m.matches())
                    strBuilder.setLength(strBuilder.length() - 1);
            }
            if (component.getComponentType()==ComponentType.PARAGRAPH && textComponents.get(textComponents.size()-1).getString()!=component.getString())
            {strBuilder.append("\r\n");}
        }
        return strBuilder.toString();
    }


    @Override
    public boolean add(TextComponent component) {
        return textComponents.add(component);
    }

    @Override
    public List<TextComponent> getComponents() {
        return textComponents;
    }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(TextComponent component) {
        return textComponents.remove(component);
    }

}
