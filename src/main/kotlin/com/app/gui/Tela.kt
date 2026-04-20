package com.app.gui

import com.app.enums.MonsterEnum
import com.app.service.MonsterService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.awt.GridBagConstraints
import java.awt.GridBagLayout
import java.awt.Insets
import javax.swing.*
import javax.swing.SwingConstants.LEFT
import javax.swing.text.DefaultCaret
import kotlin.system.exitProcess

class Tela : JFrame("Monster Scrapper") {

    private val textArea: JTextArea = JTextArea(0, 0)
    private val monsterList = JList(MonsterEnum.entries.toTypedArray())
    private val errorButton: JButton = JButton("Nothing")
    private val monsterService: MonsterService = MonsterService()

    init {

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 600)
        setLocationRelativeTo(null)
        layout = GridBagLayout()
        isResizable = false

        val gbc = GridBagConstraints().apply {
            fill = GridBagConstraints.BOTH
            weightx = 1.0
            weighty = 1.0
            insets = Insets(5, 5, 5, 5)
        }

        createMonsterList(this, gbc)
        createAndAddButtons(this, gbc)
        createTextArea(this, gbc)
    }

    fun createMonsterList(frame: JFrame, gbc: GridBagConstraints) {

        monsterList.cellRenderer = DefaultListCellRenderer().apply {
            horizontalAlignment = LEFT
        }

        val scroll = JScrollPane(monsterList)

        gbc.gridx = 0
        gbc.gridy = 0
        gbc.gridheight = 1
        frame.add(scroll, gbc)
    }

    fun createAndAddButtons(frame: JFrame, gbc: GridBagConstraints) {

        val json = Json { prettyPrint = true }
        val debugButton = JButton("Buscar")
        debugButton.addActionListener {
            textArea.text = ""

            val jsonString = json.encodeToString(
                monsterService
                    .getMonsterByName(monsterList.selectedValue)
            )
            textArea.append(jsonString)
        }
        gbc.gridx = 1
        gbc.gridy = 0
        gbc.gridheight = 1
        frame.add(debugButton, gbc)
    }

    fun createTextArea(frame: JFrame, gbc: GridBagConstraints) {

        textArea.apply {
            lineWrap = true
            wrapStyleWord = true
            isEditable = false
            textArea.isEditable = false
        }
        val caret = textArea.caret as DefaultCaret
        caret.updatePolicy = DefaultCaret.NEVER_UPDATE
        val scrollPane = JScrollPane(textArea)// Lambda listener
        gbc.gridx = 0
        gbc.gridy = 2
        gbc.gridheight = 1
        gbc.gridwidth = 2
        frame.add(scrollPane, gbc)
    }
}