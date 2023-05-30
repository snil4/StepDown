import axios from "axios";
import SongModel from "../Models/SongModel";
import config from "../Util/config";

class SongService {
    public async getSong(SongId: number): Promise<SongModel> {
        const response = await axios.get(`${config.songURL}${SongId}`);
        return response.data;
    }

    public async getAllSongs(): Promise<SongModel[]> {
        const response = await axios.get(`${config.songURL}all`);
        return response.data;
    }

    public async addSong(song: SongModel) {
        const response = await axios.post(`${config.songURL}`, song);
        return response.data;
    }

    public async updateSong(song: SongModel) {
        const response = await axios.put(`${config.songURL}`, song);
        return response.data;
    }

    public async deleteSong(songId: number) {
        const response = await axios.delete(`${config.songURL}${songId}`);
        return response.data;
    }
}

const songService = new SongService()

export default songService;