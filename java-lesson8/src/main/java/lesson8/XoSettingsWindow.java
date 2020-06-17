package lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Создаем класс окна настроек

public class XoSettingsWindow extends JFrame {

    //Задаем величины для размеров и положения окна настроек

    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 270;

    //Задаем минимальные размеры победы и поля, максимальный размер поля

    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;

    //Задаем названия для ползунков

    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длина победы в символах: ";

    //Объявляем основное окно, радиокнопки режимов игры и ползунки с размерами победы/поля

    private XoWindow xoWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLen;
    private JSlider slideFieldSize;

    //Создаем конструктор окна настроек
    //с заданием размеров и положения окна относительно основного окна,
    //запрещаем менять размер окна настроек,
    //устанавливаем заголовок окна,
    //задаем расположение 8 элементов в центре окна
    //вызываем методы для добавления 8 элементов настроек в окно настроек

    public XoSettingsWindow(XoWindow xoWindow) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //НЕ СОВСЕМ ПОНЯЛ ЗАЧЕМ СЛЕДУЮЩАЯ СТРОКА

        this.xoWindow = xoWindow;
        Rectangle gameWindowBounds = xoWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Создать игру");
        setLayout(new GridLayout(8, 1));
        addGameModeButtons();
        addGameControls();

        //Создаем кнопку создания новой игры,
        //в случае срабатывания этой кнопки вызываем метод старта игры,
        //добавляем кнопку в окно настроек

        JButton btnStart = new JButton("Создать новую игру");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                classStartGame();
            }
        });
        add(btnStart);
    }

    //Метод, создающий и добавляющий в окно текстовую область,
    //две радиокнопки с выбором режима игры,
    //группу кнопок из радиокнопок,
    //устанавливаем по умолчанию режим игры с компьютером,
    //добавляем радиокнопки в окно настроек

    private void addGameModeButtons() {
        JLabel label = new JLabel(" Выберите режим");
        add(label);
        humVSAI = new JRadioButton("Человек vs Компьютер");
        humVShum = new JRadioButton("Человек vs Человек");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(humVSAI);
        buttonGroup.add(humVShum);
        humVSAI.setSelected(true);
        add(humVSAI);
        add(humVShum);
    }

    //Метод, создающий и добавляющий в окно настроек ползунки размеров поля и победы
    //и их числовые значения

    private void addGameControls() {
        final JLabel lbFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        final JLabel lbWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        slideFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slideWinLen = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        //Задаем ползунку размера поля обработку перемещения ползунка,
        //соответсвенно изменяем размер победы

        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentValue = slideFieldSize.getValue();
                lbFieldSize.setText(FIELD_SIZE_PREFIX + currentValue);
                slideWinLen.setMaximum(currentValue);
            }
        });

        //Задаем ползунку размера победы обработку перемещения ползунка

        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(WIN_LENGTH_PREFIX + slideWinLen.getValue());
            }
        });

        //Добавляем в окно настроек интерактивные тексты с размером поля и победы,
        //а также ползунки с размером поля и победы, всего 4 элемента

        add(lbFieldSize);
        add(slideFieldSize);
        add(lbWinLength);
        add(slideWinLen);
    }

    //Метод старта игры после выбора всех настроек игры,
    //передающий эти настройки в основное окно игры,
    //и закрывающий окно настроек

    private void classStartGame() {
        int gameMode;
        if(humVSAI.isSelected()) {
            gameMode = XoFieldPanel.GAME_MODE_HVAI;
        } else if (humVShum.isSelected()) {
            gameMode = XoFieldPanel.GAME_MODE_HVH;
        } else {
            throw new RuntimeException("Данный режим игры не поддерживается");
        }

        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLen.getValue();
        xoWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);
    }


}