package de.gesellix.docker.client

import org.apache.commons.io.IOUtils

class DockerignoreFileFilter {

  GlobsMatcher globsMatcher

  DockerignoreFileFilter(File base, additionalExcludes = []) {
    def dockerignore = getDockerignorePatterns(base)
    dockerignore += ".dockerignore"
    additionalExcludes.each {
      dockerignore += it
    }
    globsMatcher = new GlobsMatcher(dockerignore)
  }

  def getDockerignorePatterns(File base) {
    def dockerignoreFile = base.listFiles().find {
      def relativeFileName = relativize(base, it)
      return ".dockerignore" == relativeFileName
    }
    dockerignoreFile ? IOUtils.toString(new FileInputStream(dockerignoreFile as File)).split("[\r\n]+") : []
  }

  def relativize(File base, File absolute) {
    return base.absoluteFile.toPath().relativize(absolute.absoluteFile.toPath()).toString()
  }

  def collectFiles(File base) {
    def files = []

    base.eachFileRecurse {
      if (!globsMatcher.matches(base, it)) {
        files << it
      }
    }

    return files.findAll {
      it.isFile()
    }
  }
}
