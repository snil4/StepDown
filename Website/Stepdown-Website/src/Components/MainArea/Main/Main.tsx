import "./Main.css";
import Song from "./Song/Song";
import {useEffect, useState} from "preact/hooks";
import {signal} from "@preact/signals";
import bossy from "../../../assets/test/banners/bossy.png";
import yeah from "../../../assets/test/banners/yeah.png";
import shoes from "../../../assets/test/banners/shoes.png";
import SongModel from "../../../Models/SongModel";
import notificationService from "../../../Services/NotificationService";
import SongService from "../../../Services/SongService";
import songService from "../../../Services/SongService";

function Main() {

    const [songs, setSongs] = useState<SongModel[]>();

    useEffect(() => {
        (async () => {
            try {
                const songs = await songService.getAllSongs();
                setSongs(songs);
            } catch (error) {
                notificationService.error(error);
            }
        })();
    });

    return (
        <div className="Main min-h-screen dark:bg-slate-800 dark:text-neutral-300">
            <div className="SongList">
			    {songs?.map((c) => <Song key={c.id} song={c}/>)}
            </div>
        </div>
    );
}

export default Main;
