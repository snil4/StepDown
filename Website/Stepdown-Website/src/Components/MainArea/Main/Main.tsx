import "./Main.css";
import Song from "./Song/Song";
import {useState} from "preact/hooks";
import bossy from "../../../assets/test/banners/bossy.png";
import yeah from "../../../assets/test/banners/yeah.png";
import shoes from "../../../assets/test/banners/shoes.png";

function Main() {

    const [songs, setSongs] = useState([bossy, yeah, shoes]);

    return (
        <div className="Main min-h-screen dark:bg-slate-800 dark:text-neutral-300">
            Hello
            <div className="SongList">
			    {songs.map(e => {return (<Song key={songs.indexOf(e)} Name={e}/>)})}
            </div>
        </div>
    );
}

export default Main;
