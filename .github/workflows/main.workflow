workflow "Push" {
  on = "push"
  branch = "master"
  resolves = ["Build"]
}

action "Build" {
  uses = "MrRamych/gradle-actions@master"
  args = "build"
}