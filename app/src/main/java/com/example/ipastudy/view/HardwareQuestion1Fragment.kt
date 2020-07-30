package com.example.ipastudy.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ipastudy.R
import kotlinx.android.synthetic.main.fragment_hardware_question_1.*
import java.util.*
import kotlin.collections.ArrayList


class HardwareQuestion1Fragment : Fragment() {

    private var countLabel: TextView? = null
    private var questionLabel: TextView? = null

    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val QUIZ_COUNT = 2
    private var alertTitle: String? = null

    var quizArray: ArrayList<ArrayList<String>> = ArrayList()
    private var quizData = arrayOf(
        arrayOf(
            "コンピュータは入力,記憶,演算,制御及び出力の五つの機能を実現する各装置から取り出され、どの装置で解釈されるか",
            "取出し(記憶),解釈(制御)", "取出し(演算),解釈(制御)", "取出し(制御),解釈(演算)", "取出し(入力),解釈(演算)"
        ),
        arrayOf(
            "主記憶に記憶されたプログラムを、CPUが順に呼び出しながら実行する方式どれか",
            "プログラム格納方式", "DMA制御方式", "アドレス指定方式", "仮想記憶方式"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_hardware_question_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countLabel = view.findViewById(R.id.countLabel)
        questionLabel = view.findViewById(R.id.questionLabel)

        for (i in 0..1) {
            val tmpArray: ArrayList<String> = ArrayList()
            // クイズデータを追加
            tmpArray.add(quizData[i][0])  // 都道府県名
            tmpArray.add(quizData[i][1])  // 正解
            tmpArray.add(quizData[i][2])  // 選択肢１
            tmpArray.add(quizData[i][3])  // 選択肢２
            tmpArray.add(quizData[i][4])  // 選択肢３

            // tmpArrayをquizArrayに追加する
            quizArray.add(tmpArray);
        }
        checkAnswer()
        showNextQuiz()
    }

    // ダイアログを作成
    fun showNextQuiz() {
        // クイズカウントラベルを更新
        countLabel?.text = "Q$quizCount"

        // ランダムな数字を取得
        val random = Random(1)
        val randomNum = random.nextInt(quizArray.size)

        // randomNumを使って、quizArrayからクイズを一つ取り出す
        val quiz = quizArray[randomNum]

        // 問題文（都道府県名）を表示
        questionLabel?.text = quiz[0];

        // 正解をrightAnswerにセット
        rightAnswer = quiz[1];

        // クイズ配列から問題文（都道府県名）を削除
        quiz.removeAt(0);

        // 正解と選択肢３つをシャッフル
        quiz.shuffle();

        // 回答ボタンに正解と選択肢３つを表示
        answerBtn1?.text = quiz[0]
        answerBtn2?.text = quiz[1]
        answerBtn3?.text = quiz[2]
        answerBtn4?.text = quiz[3]

        // このクイズをquizArrayから削除
        quizArray.removeAt(randomNum)
    }

    fun checkAnswer() {
        answerBtn1.setOnClickListener {
            val btnText: String = answerBtn1.text.toString()
            if (btnText == rightAnswer) {
                alertTitle = "正解!";
                rightAnswerCount++;
            } else {
                alertTitle = "不正解...";
            }
            AlertDialog.Builder(activity) // FragmentではActivityを取得して生成
                .setTitle(alertTitle)
                .setMessage("答え : " + rightAnswer)
                .setPositiveButton("OK") { dialog, which ->
                    if (quizCount == QUIZ_COUNT) {
                        findNavController().navigate(R.id.hardWareResultFragment)
                        val bundle = Bundle()
                        bundle.putInt("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    } else {
                        quizCount++
                        showNextQuiz()
                    }
                }
                .show()
        }
        answerBtn2.setOnClickListener {
            val btnText: String = answerBtn2.text.toString()
            if (btnText == rightAnswer) {
                alertTitle = "正解!";
                rightAnswerCount++;
            } else {
                alertTitle = "不正解...";
            }
            AlertDialog.Builder(activity) // FragmentではActivityを取得して生成
                .setTitle(alertTitle)
                .setMessage("答え : " + rightAnswer)
                .setPositiveButton("OK") { dialog, which ->
                    if (quizCount == QUIZ_COUNT) {
                        findNavController().navigate(R.id.hardWareResultFragment)
                        val bundle = Bundle()
                        bundle.putInt("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    } else {
                        quizCount++
                        showNextQuiz()
                    }
                }
                .show()
        }

        answerBtn3.setOnClickListener {
            val btnText: String = answerBtn3.text.toString()
            if (btnText == rightAnswer) {
                alertTitle = "正解!";
                rightAnswerCount++;
            } else {
                alertTitle = "不正解...";
            }
            AlertDialog.Builder(activity) // FragmentではActivityを取得して生成
                .setTitle(alertTitle)
                .setMessage("答え : " + rightAnswer)
                .setPositiveButton("OK") { dialog, which ->
                    if (quizCount == QUIZ_COUNT) {
                        findNavController().navigate(R.id.hardWareResultFragment)
                        val bundle = Bundle()
                        bundle.putInt("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    } else {
                        quizCount++
                        showNextQuiz()
                    }
                }
                .show()
        }
        answerBtn4.setOnClickListener {
            val btnText: String = answerBtn4.text.toString()
            if (btnText == rightAnswer) {
                alertTitle = "正解!";
                rightAnswerCount++;
            } else {
                alertTitle = "不正解...";
            }
            AlertDialog.Builder(activity) // FragmentではActivityを取得して生成
                .setTitle(alertTitle)
                .setMessage("答え : " + rightAnswer)
                .setPositiveButton("OK") { dialog, which ->
                    if (quizCount == QUIZ_COUNT) {
                        findNavController().navigate(R.id.hardWareResultFragment)
                        val bundle = Bundle()
                        bundle.putInt("RIGHT_ANSWER_COUNT", rightAnswerCount);
                    } else {
                        quizCount++
                        showNextQuiz()
                    }
                }
                .show()
        }

    }
}


