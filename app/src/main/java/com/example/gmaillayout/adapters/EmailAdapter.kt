package com.example.gmaillayout.adapters
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.gmaillayout.R
import com.example.gmaillayout.models.Email

class EmailAdapter(private val emailList: List<Email>) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    class EmailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAvatar: ImageView = view.findViewById(R.id.tvAvatar)
        val tvSender: TextView = view.findViewById(R.id.tvSender)
        val tvSubject: TextView = view.findViewById(R.id.tvSubject)
        val tvSummary: TextView = view.findViewById(R.id.tvSummary)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emailList[position]
        holder.ivAvatar.setImageResource(email.avatarResId)
        holder.tvSender.text = email.sender
        holder.tvSubject.text = email.subject
        holder.tvSummary.text = email.summary
        holder.tvTime.text = email.time

        val bitmap = Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val shapeDrawable = ShapeDrawable(OvalShape())
        shapeDrawable.paint.color = ContextCompat.getColor(holder.itemView.context, R.color.primary)
        val textPaint = Paint()
        textPaint.color = Color.WHITE
        textPaint.textSize = 24f
        canvas.drawOval(RectF(0f, 0f, 50f, 50f), shapeDrawable.paint)
        val textWidth = textPaint.measureText(email.sender[0].toString())
        canvas.drawText(email.sender[0].toString(), (50 - textWidth) / 2, 33f, textPaint)
        holder.ivAvatar.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return emailList.size
    }
}
