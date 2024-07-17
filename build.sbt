import dependencies.projectDependencies
import com.deere.streaming_data.sbt_core.HeaderSettings

lazy val `entity-sync-api` = (project in file("."))
  .settings(commonDependenciesV2.CompilerPlugins)
  .settings(
    organization := "com.deere.streaming_data.entity_sync_api",
    libraryDependencies ++= projectDependencies,
    deereResolvers.settings,
    scalaSettings.scala213Settings,
    publishingSettings.settings,
    releaseSettings.settings,
    // add any container env vars passed in the drone file here so they get passed to the forked jvm
    javaSettings.forkedSettings(Seq()),
    AssemblySettings.settings,
    MissingLinkSettings.missingLinkSettings,
    gitHashAsVersion.settings,
    HeaderSettings.copyrightSettings("Unpublished Work © 2019-2024 Deere & Company.")
  )
  .enablePlugins(BuildInfoPlugin)