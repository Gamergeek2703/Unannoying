# 321-project

An android application that automatically analyses SMS messages and emails for spam. Additionally, it blocks phone calls based on a blacklist that was scraped from [reverseaustralia](https://www.reverseaustralia.com)

# Running

You will need the following requirements to run the project:

- Android Studio Flamingo
- python3

To get started, clone the project

```bash
git clone https://github.com/thomasdamcevski/321-project
```

The API service needs to be started and running for full functionality

## Running the API service

- Download both model.pt and model_email.pt from the GitHub releases page. Place both of them inside the /ML/web directory
- cd into the /ML/web directory
```bash
cd 321-project/ML/web
```
- Install the requirements
```bash
pip3 install -r requirements.txt
```
- Run the service
```bash
python3 api.py
```

The API should now be running

## Running the Android app

- Download debug.keystore from the releases page
- Replace the one located in C:\Users\USERNAME\.android\debug.keystore on Windows or ~/.android/debug.keystore on MacOS with the one you just downloaded
- Open the 321-project/UnAnnoying folder in Android Studio
- You will probably need to make a [run configuration](https://developer.android.com/studio/run/rundebugconfig)
- Run the project
- Follow the instructions [here](https://github.com/thomasdamcevski/321-project/tree/main/UnAnnoying) to setup the app
- Make sure that the app is turned on by pressing the power button on the home page
- You can use the phone tab within the emulator's extended controls to simulate phone calls and SMS messages

Then open 321-project/UnAnnoying in Android Studio. You will need to make a run configuration. 
