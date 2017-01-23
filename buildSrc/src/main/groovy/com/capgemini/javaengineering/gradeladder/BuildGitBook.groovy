package com.capgemini.javaengineering.gradeladder

import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.ParallelizableTask
import org.gradle.api.tasks.TaskAction

@ParallelizableTask
class BuildGitBook extends Exec {

    @InputDirectory
    File inputDirectory

    @OutputDirectory
    File outputDirectory

    String type

    BuildGitBook() {
        this.executable = 'gitbook'
    }

    @TaskAction
    void doBuild() {
        this.args = [type, "$inputDirectory.parent", "$outputDirectory.absolutePath/capgemini_grade_ladder.$type", "--verbose"]
        super.exec()
    }

    void setType(String type) {
        this.type = type
        this.outputDirectory = project.file("${project.buildDir}/output/$type")
    }

}
