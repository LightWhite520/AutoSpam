package com.sparkle;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

public class Main implements NativeKeyListener {
    static ArrayList<String> vocabulary;
    static boolean enable = false;

    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        } catch (NativeHookException ignored) {}
//
//        GlobalScreen.addNativeKeyListener(new Main());
        InputStream is = new Main().getResources("vocabulary.txt");
        vocabulary = read(is);
//        while (true) {
//            new Main();
//            if (enable) {
//
//            }
//        }
        for (int i = 0; i < vocabulary.size(); i++) {
            String voc = vocabulary.get(i);
            RobotUtil.sendKey(PinyinUtil.getFullPinyin(voc));
//            System.out.println(PinyinUtil.getFullPinyin(voc));
//            System.out.println(voc);
        }
    }

    public InputStream getResources(String path) {
        try {
            return getClass().getResource("/" + path).openStream();
        } catch (IOException e) {
            return null;
        }
    }


    private static ArrayList<String> read(InputStream is) {
        ArrayList<String> result = new ArrayList<>();
        try {
            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            while ((inputLine = in.readLine()) != null) {
                result.add(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        if (nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_HOME) {
            enable = !enable;
        }
    }
}
