package org.cf.sdbg.command

import org.jline.reader.LineReader
import org.jline.reader.impl.LineReaderImpl
import picocli.CommandLine
import java.io.PrintWriter

@CommandLine.Command(name = "", footer = ["", "Press Ctl-D to exit."],
        description = [
            "Smali DeBuGger (SDBG) Hit @|magenta <TAB>|@ to see available commands.",
            "Type `@|bold,yellow keymap ^[s tailtip-toggle|@`, then hit @|magenta ALT-S|@ to toggle tailtips.",
            ""
        ],
        subcommands = [
            CommandLine.HelpCommand::class,
            //MyCommand::class,
            ClearScreenCommand::class,
            List::class,
            WhereCommand::class,
            StepCommand::class,
            InfoCommand::class
        ])
class CliCommands : Runnable {
    lateinit var reader: LineReaderImpl
    lateinit var out: PrintWriter
    fun setReader(reader: LineReader) {
        this.reader = reader as LineReaderImpl
        out = reader.terminal.writer()

    }

    override fun run() {
        out.println(CommandLine(this).usageMessage)
    }
}
