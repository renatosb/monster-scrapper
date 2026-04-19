package com.app.gui

import com.app.enums.MonsterEnum
import com.app.scrapper.functions.MovesScrapper
import com.app.scrapper.functions.StatsScrapper
import com.app.service.MonsterService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.awt.GridLayout
import javax.swing.*
import javax.swing.text.DefaultCaret
import kotlin.system.exitProcess

class Tela : JFrame("Monster Scrapper") {

    private val textArea: JTextArea
    private val errorButton: JButton = JButton("Nothing")
    private val monsterService: MonsterService = MonsterService()

    init {

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(600, 500)
        setLocationRelativeTo(null)
        layout = GridLayout(0, 1)

        val buttonsPanel = JPanel()
        buttonsPanel.layout = GridLayout(0, 1)
        createAndAddButtons(buttonsPanel)
        add(buttonsPanel)

        textArea = JTextArea(0, 0)
        textArea.isEditable = false
        val caret = textArea.caret as DefaultCaret
        caret.updatePolicy = DefaultCaret.NEVER_UPDATE

        val scrollPane = JScrollPane(textArea)// Lambda listener

        add(buttonsPanel)
        add(scrollPane)
    }

    fun createAndAddButtons(buttonPanel: JPanel) {

//        val finStatsBtn = JButton("Find Stats")
//        val listOfMonsterUrls = MonsterEnum.entries
//        val listOfMonsters = StatsScrapper.getMonster(
//            StatsScrapper.createUrlsByMonsterName(listOfMonsterUrls)
//        )
//        finStatsBtn.addActionListener {
//            textArea.text = ""
//
//            val json = Json { prettyPrint = true }
//            val jsonString = json.encodeToString(listOfMonsters)
//            textArea.append(jsonString)
//        }
//        buttonPanel.add(finStatsBtn)
//
//        val listMonstersBtn = JButton("List Monsters")
//        listMonstersBtn.addActionListener {
//            textArea.text = ""
//
//            textArea.append(StatsScrapper.getAllMonsters().toString())
//        }
//        buttonPanel.add(listMonstersBtn)

        val debugButton = JButton("Debug")
        debugButton.addActionListener {
            MovesScrapper.getMoveBySerebiiDexTable()
        }
        buttonPanel.add(debugButton)

        val closeBtn = JButton("Close")
        closeBtn.addActionListener { exitProcess(0) }
        buttonPanel.add(closeBtn)
    }
}