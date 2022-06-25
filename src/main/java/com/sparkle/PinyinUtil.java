package com.sparkle;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Skid CSDN
 */
public class PinyinUtil {
    public static String getFullPinyin(String name) {
        // ������ʽ������
        HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
        //���ô�Сд��ʽ
        outputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //����������ʽ
        outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        // ����������
        StringBuilder result = new StringBuilder();
        // �ַ�����
        char[] charArray = name.toCharArray();
        // �����ַ�
        for (char c : charArray) {
            // ���Ļᱻ���ȫƴ�������Ļᱻֱ��ƴ���ڽ���ַ�����
            if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                String[] pinyinArray = new String[0];
                try {
                    pinyinArray = PinyinHelper.toHanyuPinyinStringArray(c, outputFormat);
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
                if (pinyinArray != null) {
                    result.append(pinyinArray[0]);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
