
# 1. Introduction

Hello, thanks for showing an interest in my project. I have been working on this project while I am learning advance android development via Kotlin.

# 2. About Application

This Application uses The Movie Database (TMDB) website's free API to display popular Movies , Tv Shows & People. This application follows MVVM Clean (Multi view-ViewModel) Architecture. This application has reached a certain level of operability but consist of few bugs which will be elaborated in the Limitations section of this file. Also this app won't work if import the code into android studio and try to run it, kindly read How to use section of this file to understand how to make the app functional.

## 2.1 About MVVM Clean Architecture

The Structure of application is as follows:

![6](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/f0a99eb5-498d-478a-8d48-8b1056ac2e2e)


## 2.2 Screenshot of application

![1](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/8b456c08-38ad-4f34-8756-d28aed56754f)
![2](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/48b2bdc9-70dc-4b5c-baba-d9b0054d6e33)
![3](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/216cd325-c91a-48d5-842d-0e4dbe943767)
![4](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/bca4e514-05bc-4788-862b-8fb3ed8447a7)
![5](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/f750f852-1f64-48a1-abb9-a5e97b5628cb)

## 2.3 View the application

Please click on the link below to take a look at how the application is while use.

https://drive.google.com/file/d/1YOXT3F1WiDQJLJUr67KiiMThiJYDaWDA/view?usp=sharing 

## 2.4 How to use it after importing code

To use this application after downloading the source code, you would required to create an API for yourself from TMDB website.
It is a fairly easy and quick process, for your ease I'm leaving a link to a youtube video that would guide you to perform it.

YT link: https://www.youtube.com/watch?v=dCkVqY9MdUo 

Your API Key should be pasted inside app level build gradle, specifically at the location displayed in the following image:-
![7 new](https://github.com/AyushYadav1155/Popular-Movies-Tv-Shows-and-People-Mobile-Application/assets/153672671/b38a8d54-faba-4ab3-b7c4-6f0f4c2ae994)




(P.S : I am from India there is a particular issue I faced that I would other people should avoid, Jio Wifi provider seem to not respond to request sent to TMDB website and one won't be able to use the Website nor the application with that service provider. I would suggest to use mobile data of different company to access the website as well as use the app, this is also for people who live outside India if the TMDB website is not responding could be a issue with your ISP and try switching internet to access the website and API)

## 2.5 Libraries used

- Dagger
- Retrofit
- Coroutines
- Glide
- Room
- ViewModel
- Live Data

## 2.6 App Limitations

As I am still a College student in process of learning Advance android development, there are a few Limitations that this application has and in no mean it is a final product. I just want any other developer or viewer to know what this application as of this moment lacks and will be improved in the future.

- The application's update feature only works in 'Light' Mode of the Mobile.

- The update feature can only be used once per app open. (I am assuming it is due to the way I used to call the function)

- For some reason sometimes cache memory isn't updated properly.

If anyone taking an interest in this application and has a idea how to fix them kindly Email me at ayush.rk.yadav14@gmail.com (I have to learn more things in android so I have decided to move on other projects and work on this while I have free time)

## 2.7 Future Scope

I haven't given much thought on the future of this application but I would like to implement Swipe layout for refreshing and remove the toolbar altogether to avoid the hassle of fixing toolbar for Day and Night (Light & Dark) Mode.









