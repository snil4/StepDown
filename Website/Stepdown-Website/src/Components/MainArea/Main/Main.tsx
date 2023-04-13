import "./Main.css";
import Song from "./Song/Song";
import {useState} from "preact/hooks";
import {signal} from "@preact/signals";
import bossy from "../../../assets/test/banners/bossy.png";
import yeah from "../../../assets/test/banners/yeah.png";
import shoes from "../../../assets/test/banners/shoes.png";
import SongModel from "../../../Models/SongModel";

function Main() {

    const songs = signal<string[]>([bossy, yeah, shoes]);

    return (
        <div className="Main min-h-screen dark:bg-slate-800 dark:text-neutral-300">
            Hello
            <div className="SongList">
			    {songs.value.map(e => {return (<Song key={songs.value.indexOf(e)} Name={e}/>)})}
            </div>
        </div>
    );
}

export default Main;
