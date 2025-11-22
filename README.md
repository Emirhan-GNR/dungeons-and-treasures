# 🐉 Dragons or Treasure (DATP1 & DATP2) – Java Console Adventure Game

This repository contains a **Java console-based adventure game** built in two parts:

- **DATP1** → Single-player version  
- **DATP2** → Multi-player extension (array-based, turn-based system)

The project focuses on **clean game flow**, **input handling**, and **basic game state management** using plain Java (no external libraries).

---

## 🎮 Game Modes

### 1️⃣ DATP1 – Single Player

- 1 player explores a **curved 7×7 world**
- Player starts at a fixed position
- Encounters:
  - 🐉 **Dragons**
  - 💣 **Traps**
  - 💰 **Treasures**
  - 🚪 **Escape exit**
  - ⚠️ **Cliff exit** (fake/losing exit)
- Tracks:
  - Total **treasure points**
  - How many **treasures**, **dragons**, and **traps** were visited

The loop continues until the player:
- Chooses to exit through the **escape exit**, or  
- Falls from a **cliff**, or  
- Quits from the main menu.

---

### 2️⃣ DATP2 – Multi-Player (Arrays & Stats)

DATP2 extends the game to support **multiple players** in the same world:

- User selects `number of players` (stored in arrays)
- Separate arrays for each player:
  - `x_player[]`, `y_player[]`
  - `treasure_point[]`
  - `treasure_visited[]`
  - `dragon_visited[]`
  - `trap_visited[]`
  - `playerFinished[]` flags
- Players take turns moving **one by one** in a shared world:
  - Same traps, dragons, exits and treasure tiles  
  - Each player’s stats are tracked independently

At the end of the game, DATP2 calculates and prints:

- 🏆 **Winner** → Highest treasure points  
- 💰 **Treasure Collector** → Most treasure tiles visited  
- 🐉 **Dragon Briber** → Most dragons encountered  
- 💣 **Unfortunate Player** → Most traps stepped on  

This part demonstrates:
- Array usage for per-player state
- Turn-based loop design
- Simple result aggregation with helper methods like:
  - `findWinner(...)`
  - `findTreasureCollector(...)`
  - `findDragonBriber(...)`
  - `findUnfortunatePlayer(...)`
  - `allPlayersEscapedOrLost(...)`

---

## 🌍 World & Tiles

The world is a **curved 7×7 grid** (not every coordinate is reachable; movement rules depend on your row).

Important tiles:

- 🐉 **Dragon tiles**
  - Randomly generated positions
  - When you step on a dragon tile:
    - You **lose a random amount of points** between 0–9
    - `dragon_visited` counter increases
    - A message is printed: `"You lost X points !"`

- 💣 **Trap tiles**
  - Randomly generated positions
  - Stepping on a trap:
    - You **lose 5 points**
    - `trap_visited` counter increases
    - `"You pressed on a trap ! You lost 5 points !"`

- 💰 **Treasure tiles**
  - Fixed at coordinates like:
    - `(3, 3)`, `(3, 5)`, `(5, 3)`, `(5, 5)`  
  - When you reach a treasure:
    - Game prints: `"You found a treasure !"`
    - You must **guess a 4-digit number**
      - A random 4-digit number in `[1000, 9999]` is generated  
        via `fourDigitNumber(int answer)`
      - If your guess is **correct** → `+10` treasure points
      - If your guess is **wrong** → `-1` treasure point
    - `treasure_visited` counter increases

- 🚪 **Escape exit**
  - Randomly generated position `(ex1, ey1)`
  - When you step on it:
    - Shows your position
    - Asks: `"Do you want to exit ? ( y / n )"`
    - On `y`:
      - Shows **STATS** for that player:
        - Treasure points
        - Treasure visited
        - Dragons visited
        - Traps visited
      - In DATP2, marks that player as **finished**
    - On `n`:
      - You continue playing

- ⚠️ **Cliff exit**
  - Randomly generated position `(cx1, cy1)`
  - Looks like a normal exit at first:
    - `"You found an exit ! Do you want to exit ? ( y / n )"`
  - On `y`:
    - You **fall off a cliff**
    - `"You fell off a cliff ! You lost the game !"`
    - Player is marked finished / game ends (depending on mode)
  - On `n`:
    - You simply **return to the game**

---

## ⌨️ Controls

Movement is **W A S D** based:

- `w` → Move **up**
- `a` → Move **left**
- `s` → Move **down**
- `d` → Move **right**

Before each move, the game prints:

- Current player position → `(x, y)`
- Current **treasure points**
- **Treasure visited** count
- **Dragon visited** count
- **Trap visited** count

Movement is validated through `canMove(x_player, y_player, direction)`:

- The valid range of `y` depends on the `x` value  
- This creates the **curved board** feel instead of a full rectangle  
- If a move is invalid, the game prints:  
  `"You can not move there !"`

---

## 🧩 Technical Highlights

Some core techniques used in this project:

- **Input handling** with `Scanner`
  - Main menu (start / exit)
  - Direction choices (`w,a,s,d`)
  - Confirmations for exits (`y / n`)
  - Numeric input for guessing the treasure code

- **Randomization**
  - Random generation of:
    - Dragons
    - Traps
    - Escape exit
    - Cliff exit
    - 4-digit treasure code
    - Random loss from dragon encounters

- **Helper methods for game logic**
  - `canMove(...)` → world boundaries and curved grid rules
  - `random_y(int horizon)` → generates valid `y` for a given `x`
  - `isTrap(...)`, `isDragon(...)`, `isTreasure(...)`
  - `isEscapeExit(...)`, `isCliffExit(...)`
  - `fourDigitNumber(int answer)` → number guessing logic

- **State tracking**
  - Single-player:
    - Simple integer variables for points and visited counters
  - Multi-player:
    - Arrays per player (`treasure_point[i]`, `trap_visited[i]`, etc.)
    - A `boolean[] finished` array to track who is still in the game

This makes the project a good demonstration of:

- Loops & conditionals
- Methods
- Arrays
- Basic game state and input validation
- Console interaction

---
