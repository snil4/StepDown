import "./Song.css";

interface SongProps {
	Name: string;
}

function Song(props: SongProps) {
    return (
        <img width="512" src={props.Name} alt={props.Name}/>
    );
}

export default Song;
