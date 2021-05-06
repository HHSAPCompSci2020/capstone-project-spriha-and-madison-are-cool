Flappy Ordeal
Authors: Spriha Pandey, Madison Tippett
Revision: 4/24/2021


Introduction: 
Our program is a game based on the original indie game Flappy Bird, called Flappy Ordeal. In our version of Flappy Bird, we’re adding different features, such as moving obstacles, stamina, and food to refill stamina. The “flappy bird” resembles a real bird in the way it flaps, where it can flap upwards and dive downwards, and if the bird does not flap, it falls and the game ends. The goal is to keep flying for as long as possible and collect as many points and coins as it can. The rules are that the bird’s horizontal speed will remain constant, the “flapping” will raise the bird by a set amount, and as the bird falls or dives, the speed at which it falls or dives will increase. The only exceptions to these rules are if the player flies over a power up, which can increase the speed, flap power, etc. If the bird runs out of stamina, the bird falls and the game ends. As the game progresses, it will get harder, which means the obstacles may move faster and there may be more obstacles. The amount of power ups and food may also increase and decrease at random intervals to add another level of difficulty to the game. To replenish stamina, the user will have to collect (fly over) food. Other features we may implement include power ups, different types of food that can give different amounts of stamina, coins, and a shop. The audience for this game is the general population, in which anyone can play and it is not aimed towards a specific demographic. It will keep the original pixel style of the original Flappy Bird. We chose to make this game because we enjoyed the original Flappy Bird and wanted to add a challenging twist to the game. 


Instructions (Assuming we implement the stretch features):
* When the program is launched the user can click on a play button to start the game or click on the shop button to purchase items using coins that they may have collected in the game.
While playing the game
* Up arrow to flap upwards
* Down arrow to dive down
* If the player does not press either of the two buttons, the bird crashes to the ground.
* At the end of each round, there will be a pop up showing how many points, stars and coins were earned. 
* The player will have two options, they can click on the “play again” button or click on the “Shop” button to purchase items from the shop.
In the Shop
* If the user chooses to enter the shop, there will be a return button that they click on to leave the shop
* The player cannot enter the shop while they are playing. They can only enter it before they begin playing or after they are through one round.
Features List:
Must-have Features:
* Features of a basic Flappy Bird game 
   * The vanilla Flappy Bird has few features, mainly consisting of flapping up and dodging pipes. We will need to implement those features for the game. 
* Moving obstacles
   * As the bird navigates the obstacles and flaps up and down, some of the obstacles move vertically. For example, in the original Flappy Bird, the obstacles are pipes that do not move. In our version of Flappy Bird, we would have pipes that would move up and down to add an extra level of difficulty. As the player progresses, the obstacles move more frequently and faster.
* Stamina
   * The bird needs stamina to continue flying. In order to gain more stamina, the bird must collect (fly over) food. There will be a maximum stamina and a minimum stamina. As the bird approaches minimum stamina, there will be a warning. When the bird runs out of stamina, it falls down and the game ends. However, the bird cannot collect any more stamina than the maximum stamina. When flying over food, the bird will act as if the food is not there. Stamina can increase through power ups or specific foods. 
* Food
   * Food will randomly pop up between obstacles and provide stamina. The food will provide a specific amount of stamina or if the different foods are implemented, each will provide a specific amount of stamina based on the food the bird eats.
* Point counter
   * Every time the bird flies between two pipes or dodges another bird, it gets a point. At the end of the game, the number of points obtained is displayed. 
Want-to-have Features:
* Other birds
   * Other birds appear from the opposite direction and attack the flappy bird. The attacking bird flies from the opposite direction, and if it collides with the flappy bird, the flappy bird falls down. The flappy bird can flap above or dive below them to defend itself. 
* Different variety of foods
   * Functions the same as regular food. There will be a variety of food, each granting a different amount of stamina. For example, birdseed would only grant ~5% stamina, while fruit would grant ~30% stamina, and cake would grant ~100% stamina. Some foods can grant more stamina, but these foods will be rare. 
*  Power ups
   * The bird can collect specific power ups as the game progresses. Some of these power ups may include permanent stamina, the ability to pass through obstacles, moving faster, reviving the bird, etc. However, power ups that are not permanent will only last for a given amount of time. The power ups are randomly generated, but some are rarer than others and if used, will not be seen in the current game again.
* Increasing levels of difficulty
   * As the player finishes more rounds of the game, the difficulty of the game increases. The pipes start to move faster and there may be more birds that attack the flappy bird. 
* 1 - 3 stars at the end of the game
   * At the end of the game, the player is given 1 - 3 stars depending on how well they played the game. This is scored by how well they dodged the obstacles and the number of food/power ups/coins collected.


Stretch Features:
* Coins[a]
   * The bird can collect coins as it navigates through obstacles. The amount of coins the player got is shown after the game ends and can be used to purchase items in the shop. The coins only apply until the game is closed. Every time the user opens the game it is considered a new runthrough. 
* Shop
   * The player can buy power ups or different colour options here with the coins they collected throughout the game. As the player progresses, new options are unlocked. 
* Colours
   * The bird and environment can switch colours from either buying from the shop or progressing through the game. The colours will include red, green, and blue at first, and there may be more.




Class List:
* FlappyBird
* AttackerBird (maybe)
* Pipe
* Food
* PowerUps (maybe)
* Coin (maybe)
* Shop (maybe)
* Main
* MovingImage


Credits:
Still to be decided
Internal Credit:
Madison:
* Finding the graphics/images
* Pipes 
* PowerUps
* Shop
* MovingImage
Spriha:
* FlappyBird
* Food
* Coin
* AttackerBird
External Credit: 
Flappy Bird idea: Dong Nguyen and dotGears
Graphics[b]:
* Flappy Bird game
* Processing


[a]Do coins in the shop only apply to that run-through of the game (when the game is closed, is the amount of coins saved?)
[b]How are credits going to be coded in Java? Will it be done with Processing, or some other library?