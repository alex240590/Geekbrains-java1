package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Создаем класс основного окна

public class XoWindow extends JFrame {

    //Задаем величины для размеров и положения основного окна,


    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_POS_X = 650;
    private static final int WINDOW_POS_Y = 250;

    //Объявляем окно настроек и поле игры
    private XoSettingsWindow settingsWindow;
    private XoFieldPanel fieldPanel;

    //Переопределяем конструктор по умолчанию для основного окна

    public XoWindow() {

        //Вызываем методы для задания размеров и положения основного окна

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocation(WINDOW_POS_X, WINDOW_POS_Y);

        //Описываем способ закрытия окна

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Прописываем заголовок основного окна

        setTitle("Крестики - Нолики");

        //Запрещаем менять размер основного окна

        setResizable(false);

        //Создаем окно настроек

        this.settingsWindow = new XoSettingsWindow(this);

        //Создаем кнопки старта и выхода

        JButton buttonStart = createStartButton();
        JButton buttonExit = createExitButton();

        //Создаем панель для кнопок старта и выхода

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

        //Добавляем кнопки старта и выхода на панель для кнопок

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonExit);

        //Добавляем панель для кнопок в основное окно в низ окна

        add(buttonPanel, BorderLayout.SOUTH);

        //Создаем поле игры

        this.fieldPanel = new XoFieldPanel();
        add(fieldPanel, BorderLayout.CENTER);

        //Делаем основное окно видимым

        setVisible(true);
    }

    //Создаем метод запуска игры с выбранными параметрами игры

    public void startGame(int gameMode, int fieldSize, int winLength) {
        this.fieldPanel.startGame(gameMode, fieldSize, winLength);
    }

    //Метод для создания кнопки начала игры и
    //появления окна настроек в случае срабатывания этой кнопки
    //возврат наверх сработавшей кнопки

    private JButton createStartButton() {
        JButton button = new JButton("Начать игру");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        };
        button.addActionListener(listener);
        return button;
    }

    //Метод для создания кнопки выхода из игры и
    //сворачивания основного окна в случае срабатывания этой кнопки
    //возврат наверх сработавшей кнопки

    private JButton createExitButton() {
        JButton button = new JButton("<html><body><b>Выйти</b></body></html>");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        return button;
    }

}
