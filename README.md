## LDTS_<T><G> - Space Escape

> Space Escape is a game inspired by games like space invaders, but we some diferent ideas, here you land on a planet and soon you realise not only its habitated aswell its hostile. Your goal is to survive and in order to acomplish that you need to get past an asteroid field in order to be able to grav jump to your home planet, while being followed by enemies from every where!

**Game Objective**:

In this world you are a space ship that can shot or avoid asteroids
while killing enemies and earn points!
some asteroids will drop some goods or upgrades,
so you should not only avoid them ;)
Your main objective is to grav jump to your home planet, try to survive till that.

Developed by
- **Andre David Aires de Freitas** (up202007189)
- **Gonçalo Guimaraes Goncalves de Morais Figueira** (up202108804)

LDTS 2023⁄24<br>
Software Design and Testing Laboratory
### IMPLEMENTED FEATURES

> This is a list of the implemented features of the game

- **Player** - The game as a playable character, wich is a space ship. The player can be controlled by using reserved keys:
    - **Movement** - The player can move by pressing "a" key the player moves right, and by pressing "d" key the player move left, the player also as a special move the slide, you can performe that by pressing "shift", this ability has a cooldown, the player becames untouchable during a short time.
    - **Shot** - The player as the hability to shot by pressing the "j" key, and also he can drop bombs by pressing "k" key.
    - **Xp levels** - The player as a level system where he gains xp by killing enemies, when he levels up he will recieve an upgrade.
    - **Health** - The player will display an health bar with his current health.
- **Upgrades** - The player can receive some upgrades while playing by destroying asteroids or by gaining enought xp from killing enemies to level up:
    - **Damage up** - Each shot deals more damage, this increases in a linear fation.
    - **Health up** - Encrease max Hp if the player is at max Health, else restore the player health to max.
    - **Multi shot** - Shot balls in multiple directions, based on upgrade level.
    - **Burst shot** - When pressing the shot key the player will shot multiple sequencial shots, based on level.
    - **Shoting speed** - Increase shoting speed in a linear fation.
    - **Speed Boost** - Increase minimaly the speed of the player.
    - **Slider** - Decreases the cooldown of the silding hability.
- **Main Menu** - The game has a main mainMenu, that can be accessed by pressing the escape key. The main mainMenu has
  the following options:
    - **New Game** - Starts a new game.
    - **Load Game** - Starts the game in the previous scene, paused.
    - **Scores** - Displays the scores of the game
    - **Instructions** - Displays the instructions of the game.
    - **Exit** - Exits the game.
- **Scores** - The game keeps track of the top 5 scores, and displays them in a leaderboard, ordered by descending order of score.
- **Pause Screen** - The game can be paused by pressing the escape key, and the game can be resumed by selecting the 'Resume' option in the menu. The player can also exit the game by selecting the 'Exit' option and restart the game by selecting the 'Restart' option.
- **Random asteroids** - The asteroids are generated with a random distance between themselves, the size is also random, but the odds of getting a bigger asteriod are smaller, by progressing the game, the asteroids will spwan faster.
- **Background music** - The game has background music, that can be turned on and off by pressing the 'm' key. The music is different for the menus and the game.
- **Sound effects** - The game has sound effects. The sound effects can be turned on and off by pressing the 's' key.
- **Game Over Screen** - The game displays a game over screen when the player reaches 0 hp, the score of the player and the distance achieved will be stored in the scores.
- **Collision Detection** - The game detects collisions between the player and the asteroids and the shots from the enemies, and also from the player and coletables.
- **Colectables** - The player can collect some objetcts to increase his power in the game:
    - **Dropables** - This are objects that rarely drop from the asteroids, they simply are upgrades.
- **Enemies**
    - **mosquito** - This enemie is a fast pace small space ship with low hp and low damage, but fast shooting speed
    - **corvet** - This is a balanced space ship, with average shooting speed, hp and size.
    - **tanker** - This is a big space ship with high Hp, but slow in speed and shooting speed, the damage is average.

### PLANNED FEATURES

> This section is similar to the previous one but should list the features that are not yet implemented. Instead of screenshots you should include GUI mock-ups for the planned features.

### DESIGN

> This section should be organized in different subsections, each describing a different design problem that you had to solve during the project. Each subsection should be organized in four different parts:

- **Problem in Context.** The description of the design context and the concrete problem that motivated the instantiation of the pattern. Someone else other than the original developer should be able to read and understand all the motivations for the decisions made. When refering to the implementation before the pattern was applied, don’t forget to [link to the relevant lines of code](https://help.github.com/en/articles/creating-a-permanent-link-to-a-code-snippet) in the appropriate version.
- **The Pattern.** Identify the design pattern to be applied, why it was selected and how it is a good fit considering the existing design context and the problem at hand.
- **Implementation.** Show how the pattern roles, operations and associations were mapped to the concrete design classes. Illustrate it with a UML class diagram, and refer to the corresponding source code with links to the relevant lines (these should be [relative links](https://help.github.com/en/articles/about-readmes#relative-links-and-image-paths-in-readme-files). When doing this, always point to the latest version of the code.
- **Consequences.** Benefits and liabilities of the design after the pattern instantiation, eventually comparing these consequences with those of alternative solutions.

**Example of one of such subsections**:

------

#### THE JUMP ACTION OF THE KANGAROOBOY SHOULD BEHAVE DIFFERENTLY DEPENDING ON ITS STATE

**Problem in Context**

There was a lot of scattered conditional logic when deciding how the KangarooBoy should behave when jumping, as the jumps should be different depending on the items that came to his possession during the game (an helix will alow him to fly, driking a potion will allow him to jump double the height, etc.). This is a violation of the **Single Responsability Principle**. We could concentrate all the conditional logic in the same method to circumscribe the issue to that one method but the **Single Responsability Principle** would still be violated.

**The Pattern**

We have applied the **State** pattern. This pattern allows you to represent different states with different subclasses. We can switch to a different state of the application by switching to another implementation (i.e., another subclass). This pattern allowed to address the identified problems because […].

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.


These classes can be found in the following files:

**Consequences**

The use of the State Pattern in the current design allows the following benefits:

- The several states that represent the character’s hability to jump become explicit in the code, instead of relying on a series of flags.
- We don’t need to have a long set of conditional if or switch statements associated with the various states; instead, polimorphism is used to activate the right behavior.
- There are now more classes and instances to manage, but still in a reasonable number.

#### KNOWN CODE SMELLS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.

**Example**:

- John Doe: 40%
- Jane Doe: 60%



