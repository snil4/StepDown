using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using StepDown.Models;
using StepDown.Services;

namespace StepDown.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SongsController : ControllerBase
    {
        private readonly SongContext _context;

        private readonly SongService service;

        public SongsController(SongContext context)
        {
            _context = context;
        }

        // GET: api/Songs
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Song>>> GetSongs()
        {
          if (_context.Songs == null)
          {
              return NotFound();
          }
            return await _context.Songs.ToListAsync();
        }

        // GET: api/Songs/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Song>> GetSong(long id)
        {
          if (_context.Songs == null)
          {
              return NotFound();
          }
            var song = await _context.Songs.FindAsync(id);

            if (song == null)
            {
                return NotFound();
            }

            return song;
        }

        // PUT: api/Songs/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutSong(long id, Song song)
        {
            if (id != song.id)
            {
                return BadRequest();
            }

            _context.Entry(song).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SongExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Songs
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Song>> PostSong(Song song)
        {
          if (_context.Songs == null)
          {
              return Problem("Entity set 'SongContext.Songs'  is null.");
          }
            _context.Songs.Add(song);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetSong", new { id = song.id }, song);
        }

        // POST: api/Songs/parse
        [HttpPost("parse")]
        public async Task<ActionResult<Song>> ParseFile(string file) {
            return service.parseFile(file);
        }

        // DELETE: api/Songs/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSong(long id)
        {
            if (_context.Songs == null)
            {
                return NotFound();
            }
            var song = await _context.Songs.FindAsync(id);
            if (song == null)
            {
                return NotFound();
            }

            _context.Songs.Remove(song);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool SongExists(long id)
        {
            return (_context.Songs?.Any(e => e.id == id)).GetValueOrDefault();
        }
    }
}
