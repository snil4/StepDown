import SongModel from "../../../../Models/SongModel";
import config from "../../../../Util/config";
import "./Song.css";

interface SongProps {
	song: SongModel;
}

function Song(props: SongProps) {
    return (<a href={`/${props.song.id}`}>
            <img width="512" src={`${config.imageURL}${props.song.imagePath}`} alt={props.song.title}/>
        </a>
    );
}

export default Song;
