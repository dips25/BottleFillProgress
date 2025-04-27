### Welcome to the CircularProgress wiki!

## Add it in your root settings.gradle at the end of repositories:

<code> ```dependencyResolutionManagement 
{ 
repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) 
repositories {
 mavenCentral() 
 maven { url 'https://jitpack.io' } 
} 
} ```</code>

### Add the dependency

`dependencies {`
	        `implementation 'com.github.dips25:BottleFillProgress:v1.0-beta'`
	     `}`

### Use in XML(keep width/height wrap_content always)

 * `<com.anim.bottlefillanimationprogress.BottleProgress`
*         `android:layout_width="wrap_content"`
*         `android:layout_height="wrap_content"`
*         `app:layout_constraintTop_toTopOf="parent"`
*         `app:layout_constraintBottom_toBottomOf="parent"`
*         `app:layout_constraintStart_toStartOf="parent"`
*         `app:layout_constraintEnd_toEndOf="parent"`
*         `app:type="normal"`
*         `app:duration="1000"`
*         `app:waterColor="@android:color/holo_blue_bright"`
*         `android:id="@+id/bottle_progress"/>`


### Add in activity/fragment/dialog

 `bp = findViewById<BottleProgress>(R.id.bottle_progress)`

        `//set the colors(default blue)`
        `bp!!.setColors(intArrayOf(android.R.color.holo_purple`
            `,android.R.color.holo_red_dark`
            `,android.R.color.holo_green_light))`

### Start in onResume()

`override fun onResume() {`

        `super.onResume()`

        `//start when needed`
        `bp!!.startAnim()`
    `}`

### Always pause in onPause()/onStop()

`override fun onPause() {`

        `super.onPause()`

        `//stop when not needed(onPause())`
        `bp!!.stopAnim()`
    `}`

    `override fun onStop() {`

        `super.onStop()`

        `//stop when not needed(onStop)`
        `bp!!.stopAnim()`
    `}`

### Can start/stop on buton click also

`val button: Button = findViewById(R.id.button_click)`

        `button.setOnClickListener {`

            `bp!!.startAnim()`
        `}`

`val stopButton = findViewById<Button>(R.id.button_stop)`

  `stopButton.setOnClickListener {`

            `bp!!.stopAnim()`
        `}`

        

https://github.com/user-attachments/assets/dd1b8677-0f20-408e-949d-23b6fbe83207



https://github.com/user-attachments/assets/1bf21452-887c-42f4-8398-9c3a93194e02



https://github.com/user-attachments/assets/eb1d6e94-8b7b-465c-add8-a8ca7e4be1f1



https://github.com/user-attachments/assets/84c4f72e-db3d-41aa-8e99-5805e03f8af7



https://github.com/user-attachments/assets/62fd9285-0d18-438f-9005-e5d077563289



https://github.com/user-attachments/assets/d25aec76-5702-4683-b12d-dc169d529446



https://github.com/user-attachments/assets/7333fb4e-ec62-4498-9dcf-c459a525da0f


