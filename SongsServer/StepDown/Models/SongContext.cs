using Microsoft.EntityFrameworkCore;

namespace StepDown.Models;
public class SongContext : DbContext {
    public SongContext(DbContextOptions<SongContext> options) : base(options) {
        this.Database.EnsureCreated();
    }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {
        optionsBuilder.UseMySQL("server=localhost;database=song_db;user=root;password=12345678");
    }


    protected override void OnModelCreating(ModelBuilder modelBuilder) {
        base.OnModelCreating(modelBuilder);

        modelBuilder.Entity<Song>(entity => {
            entity.HasKey(e => e.id);
            entity.Property(e => e.title);
            entity.Property(e => e.artist);
            entity.Property(e => e.bpm);
            entity.HasOne(e => e.uploader).WithMany(e => e.songs)
            .HasForeignKey(e => e.uploaderId).HasPrincipalKey(e => e.id);
            entity.HasMany(e => e.charts).WithOne(e => e.song)
            .HasForeignKey(e => e.id).HasPrincipalKey(e => e.chartsId);
        });
    }

    public DbSet<Song> Songs {get; set;} = null!;
}