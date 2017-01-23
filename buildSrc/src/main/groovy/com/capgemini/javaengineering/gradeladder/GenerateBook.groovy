package com.capgemini.javaengineering.gradeladder

import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

class GenerateBook extends JavaExec {

    @InputFile
    File inputFile

    @OutputDirectory
    File outputDirectory

    GenerateBook() {
        this.main = "com.capgemini.javaengineering.gradeladder.GradeLadderGeneratorApp"
        this.classpath = project.files(['gradeladder-generator/build/libs/gradeladder-generator-1.0-SNAPSHOT.jar'])
    }

    @TaskAction
    void doGenerate() {
        this.args = ["$inputFile.absolutePath", "$outputDirectory.absolutePath"]
        super.exec()
    }

}
