workflow "New workflow" {
  on = "push"
  resolves = ["MrRamych/gradle-actions/openjdk-8@2.1"]
}

action "MrRamych/gradle-actions/openjdk-8@2.1" {
  uses = "MrRamych/gradle-actions/openjdk-8@2.1"
  args = "build"
}
